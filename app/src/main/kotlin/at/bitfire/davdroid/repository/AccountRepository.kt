/*
 * Copyright © All Contributors. See LICENSE and AUTHORS in the root directory for details.
 */

package at.bitfire.davdroid.repository

import android.Manifest
import android.accounts.Account
import android.accounts.AccountManager
import android.accounts.OnAccountsUpdateListener
import android.app.Application
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.provider.CalendarContract
import android.provider.ContactsContract
import androidx.core.content.ContextCompat
import at.bitfire.davdroid.InvalidAccountException
import at.bitfire.davdroid.R
import at.bitfire.davdroid.db.AppDatabase
import at.bitfire.davdroid.db.Credentials
import at.bitfire.davdroid.db.HomeSet
import at.bitfire.davdroid.db.Service
import at.bitfire.davdroid.log.Logger
import at.bitfire.davdroid.resource.LocalAddressBook
import at.bitfire.davdroid.resource.LocalTaskList
import at.bitfire.davdroid.servicedetection.DavResourceFinder
import at.bitfire.davdroid.servicedetection.RefreshCollectionsWorker
import at.bitfire.davdroid.settings.AccountSettings
import at.bitfire.davdroid.settings.Settings
import at.bitfire.davdroid.settings.SettingsManager
import at.bitfire.davdroid.syncadapter.AccountUtils
import at.bitfire.davdroid.syncadapter.AccountsCleanupWorker
import at.bitfire.davdroid.syncadapter.BaseSyncWorker
import at.bitfire.davdroid.syncadapter.PeriodicSyncWorker
import at.bitfire.davdroid.util.TaskUtils
import at.bitfire.vcard4android.GroupMethod
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import java.util.logging.Level
import javax.inject.Inject

/**
 * Repository for managing CalDAV/CardDAV accounts.
 *
 * *Note:* This class is not related to address book accounts, which are managed by
 * [at.bitfire.davdroid.resource.LocalAddressBook].
 */
class AccountRepository @Inject constructor(
    val context: Application,
    val db: AppDatabase,
    val settingsManager: SettingsManager,
    val serviceRepository: DavServiceRepository
) {

    private val accountType = context.getString(R.string.account_type)
    private val accountManager = AccountManager.get(context)

    /**
     * Creates a new main account with discovered services and enables periodic syncs with
     * default sync interval times.
     *
     * @param accountName   name of the account
     * @param credentials   server credentials
     * @param config        discovered server capabilities for syncable authorities
     * @param groupMethod   whether CardDAV contact groups are separate VCards or as contact categories
     *
     * @return account if account creation was successful; null otherwise (for instance because an account with this name already exists)
     */
    fun create(accountName: String, credentials: Credentials?, config: DavResourceFinder.Configuration, groupMethod: GroupMethod): Account? {
        val account = account(accountName)

        // create Android account
        val userData = AccountSettings.initialUserData(credentials)
        Logger.log.log(Level.INFO, "Creating Android account with initial config", arrayOf(account, userData))

        if (!AccountUtils.createAccount(context, account, userData, credentials?.password))
            return null

        // add entries for account to service DB
        Logger.log.log(Level.INFO, "Writing account configuration to database", config)
        try {
            val accountSettings = AccountSettings(context, account)
            val defaultSyncInterval = settingsManager.getLong(Settings.DEFAULT_SYNC_INTERVAL)

            // Configure CardDAV service
            val addrBookAuthority = context.getString(R.string.address_books_authority)
            if (config.cardDAV != null) {
                // insert CardDAV service
                val id = insertService(accountName, Service.TYPE_CARDDAV, config.cardDAV)

                // initial CardDAV account settings
                accountSettings.setGroupMethod(groupMethod)

                // start CardDAV service detection (refresh collections)
                RefreshCollectionsWorker.enqueue(context, id)

                // set default sync interval and enable sync regardless of permissions
                ContentResolver.setIsSyncable(account, addrBookAuthority, 1)
                accountSettings.setSyncInterval(addrBookAuthority, defaultSyncInterval)
            } else
                ContentResolver.setIsSyncable(account, addrBookAuthority, 0)

            // Configure CalDAV service
            if (config.calDAV != null) {
                // insert CalDAV service
                val id = insertService(accountName, Service.TYPE_CALDAV, config.calDAV)

                // start CalDAV service detection (refresh collections)
                RefreshCollectionsWorker.enqueue(context, id)

                // set default sync interval and enable sync regardless of permissions
                ContentResolver.setIsSyncable(account, CalendarContract.AUTHORITY, 1)
                accountSettings.setSyncInterval(CalendarContract.AUTHORITY, defaultSyncInterval)

                // if task provider present, set task sync interval and enable sync
                val taskProvider = TaskUtils.currentProvider(context)
                if (taskProvider != null) {
                    ContentResolver.setIsSyncable(account, taskProvider.authority, 1)
                    accountSettings.setSyncInterval(taskProvider.authority, defaultSyncInterval)
                    // further changes will be handled by TasksWatcher on app start or when tasks app is (un)installed
                    Logger.log.info("Tasks provider ${taskProvider.authority} found. Tasks sync enabled.")
                } else
                    Logger.log.info("No tasks provider found. Did not enable tasks sync.")
            } else
                ContentResolver.setIsSyncable(account, CalendarContract.AUTHORITY, 0)

        } catch(e: InvalidAccountException) {
            Logger.log.log(Level.SEVERE, "Couldn't access account settings", e)
            return null
        }
        return account
    }

    suspend fun delete(accountName: String): Boolean {
        // remove account
        val future = accountManager.removeAccount(account(accountName), null, null, null)
        return try {
            // wait for operation to complete
            withContext(Dispatchers.Default) {
                // blocks calling thread
                future.result
            }

            // delete address book accounts
            LocalAddressBook.deleteByAccount(context, accountName)

            // delete from database
            serviceRepository.deleteByAccount(accountName)

            true
        } catch (e: Exception) {
            Logger.log.log(Level.WARNING, "Couldn't remove account $accountName", e)
            false
        }
    }

    fun exists(accountName: String): Boolean =
        if (accountName.isEmpty())
            false
        else
            accountManager
                .getAccountsByType(accountType)
                .contains(Account(accountName, accountType))

    fun getAll(): Array<Account> = accountManager.getAccountsByType(accountType)

    fun getAllFlow() = callbackFlow<Set<Account>> {
        val listener = OnAccountsUpdateListener { accounts ->
            trySend(accounts.filter { it.type == accountType }.toSet())
        }
        accountManager.addOnAccountsUpdatedListener(listener, null, true)

        awaitClose {
            accountManager.removeOnAccountsUpdatedListener(listener)
        }
    }

    /**
     * Renames an account.
     *
     * **Not**: It is highly advised to re-sync the account after renaming in order to restore
     * a consistent state.
     *
     * @param oldName current name of the account
     * @param newName new name the account shall be re named to
     *
     * @throws InvalidAccountException if the account does not exist
     * @throws IllegalArgumentException if the new account name already exists
     * @throws Exception (or sub-classes) on other errors
     */
    suspend fun rename(oldName: String, newName: String) {
        val oldAccount = account(oldName)
        val newAccount = account(newName)

        // check whether new account name already exists
        if (accountManager.getAccountsByType(context.getString(R.string.account_type)).contains(newAccount))
            throw IllegalArgumentException("Account with name \"$newName\" already exists")

        // remember sync intervals
        val oldSettings = AccountSettings(context, oldAccount)
        val authorities = mutableListOf(
            context.getString(R.string.address_books_authority),
            CalendarContract.AUTHORITY
        )
        val tasksProvider = TaskUtils.currentProvider(context)
        tasksProvider?.authority?.let { authorities.add(it) }
        val syncIntervals = authorities.map { Pair(it, oldSettings.getSyncInterval(it)) }

        // rename account
        try {
            /* https://github.com/bitfireAT/davx5/issues/135
            Lock accounts cleanup so that the AccountsCleanupWorker doesn't run while we rename the account
            because this can cause problems when:
            1. The account is renamed.
            2. The AccountsCleanupWorker is called BEFORE the services table is updated.
               → AccountsCleanupWorker removes the "orphaned" services because they belong to the old account which doesn't exist anymore
            3. Now the services would be renamed, but they're not here anymore. */
            AccountsCleanupWorker.lockAccountsCleanup()

            // rename account
            val future = accountManager.renameAccount(oldAccount, newName, null, null)

            // wait for operation to complete
            withContext(Dispatchers.Default) {
                // blocks calling thread
                val newNameFromApi: Account = future.result
                if (newNameFromApi.name != newName)
                    throw IllegalStateException("renameAccount returned ${newNameFromApi.name} instead of $newName")
            }

            // account renamed, cancel maybe running synchronization of old account
            BaseSyncWorker.cancelAllWork(context, oldAccount)

            // disable periodic syncs for old account
            syncIntervals.forEach { (authority, _) ->
                PeriodicSyncWorker.disable(context, oldAccount, authority)
            }

            // update account name references in database
            serviceRepository.renameAccount(oldName, newName)

            // update main account of address book accounts
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED)
                try {
                    context.contentResolver.acquireContentProviderClient(ContactsContract.AUTHORITY)?.use { provider ->
                        for (addrBookAccount in accountManager.getAccountsByType(context.getString(R.string.account_type_address_book))) {
                            val addressBook = LocalAddressBook(context, addrBookAccount, provider)
                            if (oldAccount == addressBook.mainAccount)
                                addressBook.mainAccount = Account(newName, oldAccount.type)
                        }
                    }
                } catch (e: Exception) {
                    Logger.log.log(Level.SEVERE, "Couldn't update address book accounts", e)
                    // Couldn't update address book accounts, but this is not a fatal error (will be fixed at next sync)
                }

            // calendar provider doesn't allow changing account_name of Events
            // (all events will have to be downloaded again at next sync)

            // update account_name of local tasks
            try {
                LocalTaskList.onRenameAccount(context, oldAccount.name, newName)
            } catch (e: Exception) {
                Logger.log.log(Level.WARNING, "Couldn't propagate new account name to tasks provider", e)
                // Couldn't update task lists, but this is not a fatal error (will be fixed at next sync)
            }

            // restore sync intervals
            val newSettings = AccountSettings(context, newAccount)
            for ((authority, interval) in syncIntervals) {
                if (interval == null)
                    ContentResolver.setIsSyncable(newAccount, authority, 0)
                else {
                    ContentResolver.setIsSyncable(newAccount, authority, 1)
                    newSettings.setSyncInterval(authority, interval)
                }
            }
        } finally {
            // release AccountsCleanupWorker mutex at the end of this async coroutine
            AccountsCleanupWorker.unlockAccountsCleanup()
        }
    }


    // helpers

    private fun account(accountName: String) = Account(accountName, accountType)

    private fun insertService(accountName: String, type: String, info: DavResourceFinder.Configuration.ServiceInfo): Long {
        // insert service
        val service = Service(0, accountName, type, info.principal)
        val serviceId = db.serviceDao().insertOrReplace(service)

        // insert home sets
        val homeSetDao = db.homeSetDao()
        for (homeSet in info.homeSets)
            homeSetDao.insertOrUpdateByUrl(HomeSet(0, serviceId, true, homeSet))

        // insert collections
        val collectionDao = db.collectionDao()
        for (collection in info.collections.values) {
            collection.serviceId = serviceId
            collectionDao.insertOrUpdateByUrl(collection)
        }

        return serviceId
    }

}
/*
 * Copyright © All Contributors. See LICENSE and AUTHORS in the root directory for details.
 */

package at.bitfire.davdroid.ui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Suppress("MemberVisibilityCanBePrivate")
object M3ColorScheme {

    // copied from Material Theme Builder: Color.kt

    val primaryLight = Color(0xFF4B662C)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFFCCEDA4)
    val onPrimaryContainerLight = Color(0xFF0F2000)
    val secondaryLight = Color(0xFF2F628C)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFCEE5FF)
    val onSecondaryContainerLight = Color(0xFF001D32)
    val tertiaryLight = Color(0xFF3F6837)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFBFF0B1)
    val onTertiaryContainerLight = Color(0xFF002201)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF410002)
    val backgroundLight = Color(0xFFF9FAEF)
    val onBackgroundLight = Color(0xFF1A1C16)
    val surfaceLight = Color(0xFFF9FAEF)
    val onSurfaceLight = Color(0xFF1A1C16)
    val surfaceVariantLight = Color(0xFFE1E4D5)
    val onSurfaceVariantLight = Color(0xFF44483D)
    val outlineLight = Color(0xFF75796C)
    val outlineVariantLight = Color(0xFFC5C8BA)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF2F312A)
    val inverseOnSurfaceLight = Color(0xFFF0F2E6)
    val inversePrimaryLight = Color(0xFFB1D18A)
    val surfaceDimLight = Color(0xFFDADBD0)
    val surfaceBrightLight = Color(0xFFF9FAEF)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFF3F4E9)
    val surfaceContainerLight = Color(0xFFEEEFE4)
    val surfaceContainerHighLight = Color(0xFFE8E9DE)
    val surfaceContainerHighestLight = Color(0xFFE2E3D8)

    val primaryLightMediumContrast = Color(0xFF314A12)
    val onPrimaryLightMediumContrast = Color(0xFFFFFFFF)
    val primaryContainerLightMediumContrast = Color(0xFF617D40)
    val onPrimaryContainerLightMediumContrast = Color(0xFFFFFFFF)
    val secondaryLightMediumContrast = Color(0xFF05466E)
    val onSecondaryLightMediumContrast = Color(0xFFFFFFFF)
    val secondaryContainerLightMediumContrast = Color(0xFF4779A4)
    val onSecondaryContainerLightMediumContrast = Color(0xFFFFFFFF)
    val tertiaryLightMediumContrast = Color(0xFF234C1D)
    val onTertiaryLightMediumContrast = Color(0xFFFFFFFF)
    val tertiaryContainerLightMediumContrast = Color(0xFF547F4B)
    val onTertiaryContainerLightMediumContrast = Color(0xFFFFFFFF)
    val errorLightMediumContrast = Color(0xFF8C0009)
    val onErrorLightMediumContrast = Color(0xFFFFFFFF)
    val errorContainerLightMediumContrast = Color(0xFFDA342E)
    val onErrorContainerLightMediumContrast = Color(0xFFFFFFFF)
    val backgroundLightMediumContrast = Color(0xFFF9FAEF)
    val onBackgroundLightMediumContrast = Color(0xFF1A1C16)
    val surfaceLightMediumContrast = Color(0xFFF9FAEF)
    val onSurfaceLightMediumContrast = Color(0xFF1A1C16)
    val surfaceVariantLightMediumContrast = Color(0xFFE1E4D5)
    val onSurfaceVariantLightMediumContrast = Color(0xFF404439)
    val outlineLightMediumContrast = Color(0xFF5D6155)
    val outlineVariantLightMediumContrast = Color(0xFF787C70)
    val scrimLightMediumContrast = Color(0xFF000000)
    val inverseSurfaceLightMediumContrast = Color(0xFF2F312A)
    val inverseOnSurfaceLightMediumContrast = Color(0xFFF0F2E6)
    val inversePrimaryLightMediumContrast = Color(0xFFB1D18A)
    val surfaceDimLightMediumContrast = Color(0xFFDADBD0)
    val surfaceBrightLightMediumContrast = Color(0xFFF9FAEF)
    val surfaceContainerLowestLightMediumContrast = Color(0xFFFFFFFF)
    val surfaceContainerLowLightMediumContrast = Color(0xFFF3F4E9)
    val surfaceContainerLightMediumContrast = Color(0xFFEEEFE4)
    val surfaceContainerHighLightMediumContrast = Color(0xFFE8E9DE)
    val surfaceContainerHighestLightMediumContrast = Color(0xFFE2E3D8)

    val primaryLightHighContrast = Color(0xFF142700)
    val onPrimaryLightHighContrast = Color(0xFFFFFFFF)
    val primaryContainerLightHighContrast = Color(0xFF314A12)
    val onPrimaryContainerLightHighContrast = Color(0xFFFFFFFF)
    val secondaryLightHighContrast = Color(0xFF00243D)
    val onSecondaryLightHighContrast = Color(0xFFFFFFFF)
    val secondaryContainerLightHighContrast = Color(0xFF05466E)
    val onSecondaryContainerLightHighContrast = Color(0xFFFFFFFF)
    val tertiaryLightHighContrast = Color(0xFF002901)
    val onTertiaryLightHighContrast = Color(0xFFFFFFFF)
    val tertiaryContainerLightHighContrast = Color(0xFF234C1D)
    val onTertiaryContainerLightHighContrast = Color(0xFFFFFFFF)
    val errorLightHighContrast = Color(0xFF4E0002)
    val onErrorLightHighContrast = Color(0xFFFFFFFF)
    val errorContainerLightHighContrast = Color(0xFF8C0009)
    val onErrorContainerLightHighContrast = Color(0xFFFFFFFF)
    val backgroundLightHighContrast = Color(0xFFF9FAEF)
    val onBackgroundLightHighContrast = Color(0xFF1A1C16)
    val surfaceLightHighContrast = Color(0xFFF9FAEF)
    val onSurfaceLightHighContrast = Color(0xFF000000)
    val surfaceVariantLightHighContrast = Color(0xFFE1E4D5)
    val onSurfaceVariantLightHighContrast = Color(0xFF21251C)
    val outlineLightHighContrast = Color(0xFF404439)
    val outlineVariantLightHighContrast = Color(0xFF404439)
    val scrimLightHighContrast = Color(0xFF000000)
    val inverseSurfaceLightHighContrast = Color(0xFF2F312A)
    val inverseOnSurfaceLightHighContrast = Color(0xFFFFFFFF)
    val inversePrimaryLightHighContrast = Color(0xFFD6F7AD)
    val surfaceDimLightHighContrast = Color(0xFFDADBD0)
    val surfaceBrightLightHighContrast = Color(0xFFF9FAEF)
    val surfaceContainerLowestLightHighContrast = Color(0xFFFFFFFF)
    val surfaceContainerLowLightHighContrast = Color(0xFFF3F4E9)
    val surfaceContainerLightHighContrast = Color(0xFFEEEFE4)
    val surfaceContainerHighLightHighContrast = Color(0xFFE8E9DE)
    val surfaceContainerHighestLightHighContrast = Color(0xFFE2E3D8)

    val primaryDark = Color(0xFFB1D18A)
    val onPrimaryDark = Color(0xFF1F3701)
    val primaryContainerDark = Color(0xFF344E16)
    val onPrimaryContainerDark = Color(0xFFCCEDA4)
    val secondaryDark = Color(0xFF9BCBFB)
    val onSecondaryDark = Color(0xFF003353)
    val secondaryContainerDark = Color(0xFF0D4A73)
    val onSecondaryContainerDark = Color(0xFFCEE5FF)
    val tertiaryDark = Color(0xFFA4D396)
    val onTertiaryDark = Color(0xFF10380C)
    val tertiaryContainerDark = Color(0xFF275021)
    val onTertiaryContainerDark = Color(0xFFBFF0B1)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF12140E)
    val onBackgroundDark = Color(0xFFE2E3D8)
    val surfaceDark = Color(0xFF12140E)
    val onSurfaceDark = Color(0xFFE2E3D8)
    val surfaceVariantDark = Color(0xFF44483D)
    val onSurfaceVariantDark = Color(0xFFC5C8BA)
    val outlineDark = Color(0xFF8E9285)
    val outlineVariantDark = Color(0xFF44483D)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFE2E3D8)
    val inverseOnSurfaceDark = Color(0xFF2F312A)
    val inversePrimaryDark = Color(0xFF4B662C)
    val surfaceDimDark = Color(0xFF12140E)
    val surfaceBrightDark = Color(0xFF383A32)
    val surfaceContainerLowestDark = Color(0xFF0C0F09)
    val surfaceContainerLowDark = Color(0xFF1A1C16)
    val surfaceContainerDark = Color(0xFF1E201A)
    val surfaceContainerHighDark = Color(0xFF282B24)
    val surfaceContainerHighestDark = Color(0xFF33362E)

    val primaryDarkMediumContrast = Color(0xFFB5D58E)
    val onPrimaryDarkMediumContrast = Color(0xFF0C1A00)
    val primaryContainerDarkMediumContrast = Color(0xFF7C9A59)
    val onPrimaryContainerDarkMediumContrast = Color(0xFF000000)
    val secondaryDarkMediumContrast = Color(0xFF9FCFFF)
    val onSecondaryDarkMediumContrast = Color(0xFF00182A)
    val secondaryContainerDarkMediumContrast = Color(0xFF6595C2)
    val onSecondaryContainerDarkMediumContrast = Color(0xFF000000)
    val tertiaryDarkMediumContrast = Color(0xFFA8D79A)
    val onTertiaryDarkMediumContrast = Color(0xFF001C01)
    val tertiaryContainerDarkMediumContrast = Color(0xFF709C65)
    val onTertiaryContainerDarkMediumContrast = Color(0xFF000000)
    val errorDarkMediumContrast = Color(0xFFFFBAB1)
    val onErrorDarkMediumContrast = Color(0xFF370001)
    val errorContainerDarkMediumContrast = Color(0xFFFF5449)
    val onErrorContainerDarkMediumContrast = Color(0xFF000000)
    val backgroundDarkMediumContrast = Color(0xFF12140E)
    val onBackgroundDarkMediumContrast = Color(0xFFE2E3D8)
    val surfaceDarkMediumContrast = Color(0xFF12140E)
    val onSurfaceDarkMediumContrast = Color(0xFFFBFCF0)
    val surfaceVariantDarkMediumContrast = Color(0xFF44483D)
    val onSurfaceVariantDarkMediumContrast = Color(0xFFC9CCBE)
    val outlineDarkMediumContrast = Color(0xFFA1A497)
    val outlineVariantDarkMediumContrast = Color(0xFF818578)
    val scrimDarkMediumContrast = Color(0xFF000000)
    val inverseSurfaceDarkMediumContrast = Color(0xFFE2E3D8)
    val inverseOnSurfaceDarkMediumContrast = Color(0xFF282B24)
    val inversePrimaryDarkMediumContrast = Color(0xFF354F17)
    val surfaceDimDarkMediumContrast = Color(0xFF12140E)
    val surfaceBrightDarkMediumContrast = Color(0xFF383A32)
    val surfaceContainerLowestDarkMediumContrast = Color(0xFF0C0F09)
    val surfaceContainerLowDarkMediumContrast = Color(0xFF1A1C16)
    val surfaceContainerDarkMediumContrast = Color(0xFF1E201A)
    val surfaceContainerHighDarkMediumContrast = Color(0xFF282B24)
    val surfaceContainerHighestDarkMediumContrast = Color(0xFF33362E)

    val primaryDarkHighContrast = Color(0xFFF4FFE0)
    val onPrimaryDarkHighContrast = Color(0xFF000000)
    val primaryContainerDarkHighContrast = Color(0xFFB5D58E)
    val onPrimaryContainerDarkHighContrast = Color(0xFF000000)
    val secondaryDarkHighContrast = Color(0xFFFAFAFF)
    val onSecondaryDarkHighContrast = Color(0xFF000000)
    val secondaryContainerDarkHighContrast = Color(0xFF9FCFFF)
    val onSecondaryContainerDarkHighContrast = Color(0xFF000000)
    val tertiaryDarkHighContrast = Color(0xFFF1FFE8)
    val onTertiaryDarkHighContrast = Color(0xFF000000)
    val tertiaryContainerDarkHighContrast = Color(0xFFA8D79A)
    val onTertiaryContainerDarkHighContrast = Color(0xFF000000)
    val errorDarkHighContrast = Color(0xFFFFF9F9)
    val onErrorDarkHighContrast = Color(0xFF000000)
    val errorContainerDarkHighContrast = Color(0xFFFFBAB1)
    val onErrorContainerDarkHighContrast = Color(0xFF000000)
    val backgroundDarkHighContrast = Color(0xFF12140E)
    val onBackgroundDarkHighContrast = Color(0xFFE2E3D8)
    val surfaceDarkHighContrast = Color(0xFF12140E)
    val onSurfaceDarkHighContrast = Color(0xFFFFFFFF)
    val surfaceVariantDarkHighContrast = Color(0xFF44483D)
    val onSurfaceVariantDarkHighContrast = Color(0xFFF9FCED)
    val outlineDarkHighContrast = Color(0xFFC9CCBE)
    val outlineVariantDarkHighContrast = Color(0xFFC9CCBE)
    val scrimDarkHighContrast = Color(0xFF000000)
    val inverseSurfaceDarkHighContrast = Color(0xFFE2E3D8)
    val inverseOnSurfaceDarkHighContrast = Color(0xFF000000)
    val inversePrimaryDarkHighContrast = Color(0xFF1A3000)
    val surfaceDimDarkHighContrast = Color(0xFF12140E)
    val surfaceBrightDarkHighContrast = Color(0xFF383A32)
    val surfaceContainerLowestDarkHighContrast = Color(0xFF0C0F09)
    val surfaceContainerLowDarkHighContrast = Color(0xFF1A1C16)
    val surfaceContainerDarkHighContrast = Color(0xFF1E201A)
    val surfaceContainerHighDarkHighContrast = Color(0xFF282B24)
    val surfaceContainerHighestDarkHighContrast = Color(0xFF33362E)


    // copied from Material Theme Builder: Theme.kt

    val lightScheme = lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

    val darkScheme = darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

    val mediumContrastLightColorScheme = lightColorScheme(
        primary = primaryLightMediumContrast,
        onPrimary = onPrimaryLightMediumContrast,
        primaryContainer = primaryContainerLightMediumContrast,
        onPrimaryContainer = onPrimaryContainerLightMediumContrast,
        secondary = secondaryLightMediumContrast,
        onSecondary = onSecondaryLightMediumContrast,
        secondaryContainer = secondaryContainerLightMediumContrast,
        onSecondaryContainer = onSecondaryContainerLightMediumContrast,
        tertiary = tertiaryLightMediumContrast,
        onTertiary = onTertiaryLightMediumContrast,
        tertiaryContainer = tertiaryContainerLightMediumContrast,
        onTertiaryContainer = onTertiaryContainerLightMediumContrast,
        error = errorLightMediumContrast,
        onError = onErrorLightMediumContrast,
        errorContainer = errorContainerLightMediumContrast,
        onErrorContainer = onErrorContainerLightMediumContrast,
        background = backgroundLightMediumContrast,
        onBackground = onBackgroundLightMediumContrast,
        surface = surfaceLightMediumContrast,
        onSurface = onSurfaceLightMediumContrast,
        surfaceVariant = surfaceVariantLightMediumContrast,
        onSurfaceVariant = onSurfaceVariantLightMediumContrast,
        outline = outlineLightMediumContrast,
        outlineVariant = outlineVariantLightMediumContrast,
        scrim = scrimLightMediumContrast,
        inverseSurface = inverseSurfaceLightMediumContrast,
        inverseOnSurface = inverseOnSurfaceLightMediumContrast,
        inversePrimary = inversePrimaryLightMediumContrast,
        surfaceDim = surfaceDimLightMediumContrast,
        surfaceBright = surfaceBrightLightMediumContrast,
        surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
        surfaceContainerLow = surfaceContainerLowLightMediumContrast,
        surfaceContainer = surfaceContainerLightMediumContrast,
        surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
        surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
    )

    val highContrastLightColorScheme = lightColorScheme(
        primary = primaryLightHighContrast,
        onPrimary = onPrimaryLightHighContrast,
        primaryContainer = primaryContainerLightHighContrast,
        onPrimaryContainer = onPrimaryContainerLightHighContrast,
        secondary = secondaryLightHighContrast,
        onSecondary = onSecondaryLightHighContrast,
        secondaryContainer = secondaryContainerLightHighContrast,
        onSecondaryContainer = onSecondaryContainerLightHighContrast,
        tertiary = tertiaryLightHighContrast,
        onTertiary = onTertiaryLightHighContrast,
        tertiaryContainer = tertiaryContainerLightHighContrast,
        onTertiaryContainer = onTertiaryContainerLightHighContrast,
        error = errorLightHighContrast,
        onError = onErrorLightHighContrast,
        errorContainer = errorContainerLightHighContrast,
        onErrorContainer = onErrorContainerLightHighContrast,
        background = backgroundLightHighContrast,
        onBackground = onBackgroundLightHighContrast,
        surface = surfaceLightHighContrast,
        onSurface = onSurfaceLightHighContrast,
        surfaceVariant = surfaceVariantLightHighContrast,
        onSurfaceVariant = onSurfaceVariantLightHighContrast,
        outline = outlineLightHighContrast,
        outlineVariant = outlineVariantLightHighContrast,
        scrim = scrimLightHighContrast,
        inverseSurface = inverseSurfaceLightHighContrast,
        inverseOnSurface = inverseOnSurfaceLightHighContrast,
        inversePrimary = inversePrimaryLightHighContrast,
        surfaceDim = surfaceDimLightHighContrast,
        surfaceBright = surfaceBrightLightHighContrast,
        surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
        surfaceContainerLow = surfaceContainerLowLightHighContrast,
        surfaceContainer = surfaceContainerLightHighContrast,
        surfaceContainerHigh = surfaceContainerHighLightHighContrast,
        surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
    )

    val mediumContrastDarkColorScheme = darkColorScheme(
        primary = primaryDarkMediumContrast,
        onPrimary = onPrimaryDarkMediumContrast,
        primaryContainer = primaryContainerDarkMediumContrast,
        onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
        secondary = secondaryDarkMediumContrast,
        onSecondary = onSecondaryDarkMediumContrast,
        secondaryContainer = secondaryContainerDarkMediumContrast,
        onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
        tertiary = tertiaryDarkMediumContrast,
        onTertiary = onTertiaryDarkMediumContrast,
        tertiaryContainer = tertiaryContainerDarkMediumContrast,
        onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
        error = errorDarkMediumContrast,
        onError = onErrorDarkMediumContrast,
        errorContainer = errorContainerDarkMediumContrast,
        onErrorContainer = onErrorContainerDarkMediumContrast,
        background = backgroundDarkMediumContrast,
        onBackground = onBackgroundDarkMediumContrast,
        surface = surfaceDarkMediumContrast,
        onSurface = onSurfaceDarkMediumContrast,
        surfaceVariant = surfaceVariantDarkMediumContrast,
        onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
        outline = outlineDarkMediumContrast,
        outlineVariant = outlineVariantDarkMediumContrast,
        scrim = scrimDarkMediumContrast,
        inverseSurface = inverseSurfaceDarkMediumContrast,
        inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
        inversePrimary = inversePrimaryDarkMediumContrast,
        surfaceDim = surfaceDimDarkMediumContrast,
        surfaceBright = surfaceBrightDarkMediumContrast,
        surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
        surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
        surfaceContainer = surfaceContainerDarkMediumContrast,
        surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
        surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
    )

    val highContrastDarkColorScheme = darkColorScheme(
        primary = primaryDarkHighContrast,
        onPrimary = onPrimaryDarkHighContrast,
        primaryContainer = primaryContainerDarkHighContrast,
        onPrimaryContainer = onPrimaryContainerDarkHighContrast,
        secondary = secondaryDarkHighContrast,
        onSecondary = onSecondaryDarkHighContrast,
        secondaryContainer = secondaryContainerDarkHighContrast,
        onSecondaryContainer = onSecondaryContainerDarkHighContrast,
        tertiary = tertiaryDarkHighContrast,
        onTertiary = onTertiaryDarkHighContrast,
        tertiaryContainer = tertiaryContainerDarkHighContrast,
        onTertiaryContainer = onTertiaryContainerDarkHighContrast,
        error = errorDarkHighContrast,
        onError = onErrorDarkHighContrast,
        errorContainer = errorContainerDarkHighContrast,
        onErrorContainer = onErrorContainerDarkHighContrast,
        background = backgroundDarkHighContrast,
        onBackground = onBackgroundDarkHighContrast,
        surface = surfaceDarkHighContrast,
        onSurface = onSurfaceDarkHighContrast,
        surfaceVariant = surfaceVariantDarkHighContrast,
        onSurfaceVariant = onSurfaceVariantDarkHighContrast,
        outline = outlineDarkHighContrast,
        outlineVariant = outlineVariantDarkHighContrast,
        scrim = scrimDarkHighContrast,
        inverseSurface = inverseSurfaceDarkHighContrast,
        inverseOnSurface = inverseOnSurfaceDarkHighContrast,
        inversePrimary = inversePrimaryDarkHighContrast,
        surfaceDim = surfaceDimDarkHighContrast,
        surfaceBright = surfaceBrightDarkHighContrast,
        surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
        surfaceContainerLow = surfaceContainerLowDarkHighContrast,
        surfaceContainer = surfaceContainerDarkHighContrast,
        surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
        surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
    )

    @Immutable
    data class ColorFamily(
        val color: Color,
        val onColor: Color,
        val colorContainer: Color,
        val onColorContainer: Color
    )

}
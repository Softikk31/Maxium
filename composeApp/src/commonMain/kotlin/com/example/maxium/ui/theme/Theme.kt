package com.example.maxium.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Brush
import com.example.core.Theme
import com.example.maxium.ui.main.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

val LightPrimaryGradient = Brush.linearGradient(
    0f to DarkBlue, 100f to Purple
)

val DarkPrimaryGradient = Brush.linearGradient(
    0f to Blue, 100f to DarkPurple
)

val ColorScheme.primaryGradient: Brush
    @Composable get() = if (isSystemInDarkTheme()) DarkPrimaryGradient else LightPrimaryGradient

val LightColorScheme = lightColorScheme(
    secondary = VeryDarkBlue,
    tertiary = Purple,
    surface = White,
    onSurface = Black,
    onSurfaceVariant = Grey,
    surfaceContainer = DarkWhite,
    outline = DarkWhiteVariant,
    error = Red
)

val DarkColorScheme = darkColorScheme(
    secondary = DarkBlue,
    tertiary = Blue,
    surface = LightBlack,
    onSurface = White,
    onSurfaceVariant = GreyVariant,
    surfaceContainer = DarkGrey,
    outline = DarkGreyVariant,
    error = Red
)

@Composable
fun MaxiumTheme(
    viewModel: SettingsViewModel = koinViewModel<SettingsViewModel>(),
    content: @Composable () -> Unit
) {
    val theme by viewModel.theme.collectAsState()

    val isDarkMode = when (theme) {
        Theme.System -> isSystemInDarkTheme()
        Theme.Light -> false
        Theme.Dark -> true
    }

    MaterialTheme(
        colorScheme = if (isDarkMode) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
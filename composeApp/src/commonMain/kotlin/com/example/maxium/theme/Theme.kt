package com.example.maxium.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

val LightPrimaryGradient = Brush.linearGradient(
    0f to DarkBlue,
    100f to Purple
)

val DarkPrimaryGradient = Brush.linearGradient(
    0f to Blue,
    100f to DarkPurple
)

val ColorScheme.primaryGradient: Brush
    @Composable
    get() = if (isSystemInDarkTheme()) DarkPrimaryGradient else LightPrimaryGradient

val LightColorScheme = lightColorScheme(
    secondary = VeryDarkBlue,
    tertiary = Purple,
    surface = White,
    onSurface = Black,
    onSurfaceVariant = Grey,
    surfaceContainer = DarkWhite,
    error = Red
)

val DarkColorScheme = darkColorScheme(
    secondary = DarkBlue,
    tertiary = Blue,
    surface = LightBlack,
    onSurface = White,
    onSurfaceVariant = Grey,
    surfaceContainer = DarkGrey,
    error = Red
)

@Composable
fun MaxiumTheme(content: @Composable () -> Unit) {
    val isDarkMode = isSystemInDarkTheme()

    MaterialTheme(
        colorScheme = if (isDarkMode) DarkColorScheme else LightColorScheme,
        content = content
    )
}
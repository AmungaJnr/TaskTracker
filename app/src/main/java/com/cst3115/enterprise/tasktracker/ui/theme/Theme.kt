package com.cst3115.enterprise.tasktracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColor = darkColorScheme(
    primary = Color(0xFF9CCBFF),
    onPrimary = Color(0xFF003258),
    primaryContainer = Color(0xFF164B74),
    onPrimaryContainer = Color(0xFFDCEEFF),

    secondary = Color(0xFF80D5CC),
    onSecondary = Color(0xFF003D3A),
    secondaryContainer = Color(0xFF005753),
    onSecondaryContainer = Color(0xFFD3F3ED),

    background = Color(0xFF101C26),
    onBackground = Color(0xFFE0EAF2),

    surface = Color(0xFF101C26),
    onSurface = Color(0xFFE0EAF2),
    surfaceVariant = Color(0xFF263846),
    onSurfaceVariant = Color(0xFFBDCEDC),

    outline = Color(0xFF899DAE),
    outlineVariant = Color(0xFF3C5060),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)

private val LightColor = lightColorScheme(
    primary = Color(0xFF176BBD),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDCEEFF),
    onPrimaryContainer = Color(0xFF123451),


    secondary = Color(0xFF007D79),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD3F3ED),
    onSecondaryContainer = Color(0xFF003D3A),

    background = Color(0xFFF6FAFD),
    onBackground = Color(0xFF172B3A),

    surface = Color(0xFFF6FAFD),
    onSurface = Color(0xFF172B3A),
    surfaceVariant = Color(0xFFE8F0F7),
    onSurfaceVariant = Color(0xFF465C6C),

    outline = Color(0xFF718493),
    outlineVariant = Color(0xFFC4D4E0),

    error = Color(0xFFBA1A1A),
    onError = Color.White

    //tertiary = Pink40


)

@Composable
fun TaskTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColor else LightColor,
        typography = Typography,
        content = content
    )
}
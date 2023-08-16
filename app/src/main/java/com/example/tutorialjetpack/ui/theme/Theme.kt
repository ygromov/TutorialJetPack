package com.example.tutorialjetpack.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White900,         //text
    primaryVariant = Blue900,   //button
    secondary = Grey100,    //field
    background = Grey300,        //background
    surface = Green300
)

private val LightColorPalette = lightColors(
    primary = Black600,         //text
    primaryVariant = Orange200,   //button
    secondary = Grey100,    //field
    background = Grey200,       //background
    surface = Green300          //progress bar


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TutorialJetPackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
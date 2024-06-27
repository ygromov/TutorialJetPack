package com.example.tutorialjetpack.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Black610,         //text
    primaryVariant = White999,   //button
    secondary = Grey250,    //field
    background = Black900,       //background
    surface = Grey350          //progress bar

)

private val LightColorPalette = lightColors(
    primary = White900,         //text
    primaryVariant = Orange200,   //button
    secondary = Grey100,    //field
    background = Honey,        //background
    surface = Grey350


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
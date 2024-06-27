package com.example.tutorialjetpack.presentation.screens.training_screen.components

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.OriginalSize


@Composable
fun GifTraining(
    data: Int
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder(context))
            } else {
                add(GifDecoder())
            }
        }
        .build()

    Image(
        painter = rememberImagePainter(
            imageLoader = imageLoader,
            data = data,
            builder = {
                //size(width = 600, height = 400)
                size(OriginalSize)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxWidth()
    )
}
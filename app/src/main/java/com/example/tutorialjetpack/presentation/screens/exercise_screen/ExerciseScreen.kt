package com.example.tutorialjetpack.presentation.screens.exercise_screen


import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.OriginalSize
import com.example.tutorialjetpack.R


@Composable
fun ExerciseScreen(
    exerciseState: ExerciseState,
    navController: NavController,
    onEvent: (ExersizeEvent) -> Unit,
) {
ImageExample()
}

@Composable
fun ImageExample(
                 modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder(context))
            } else {
                add(GifDecoder())
            }
        }
        .build()

    Image(
        painter = rememberImagePainter(
            imageLoader = imageLoader,
            data = R.drawable.pushups,
            builder = {
                size(OriginalSize)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 4.dp)
    )
}

package com.example.tutorialjetpack.presentation.screens.intermediate_first_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.utils.Routers
import kotlinx.coroutines.delay

@Composable
fun IntermediateFirstScreen(navController: NavController) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.background_gradient),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 0.4f
    )
    var downloadProgressAbs by remember { mutableStateOf(0.1f) }
    val animatedDownloadProgressPush by animateFloatAsState(
        targetValue = downloadProgressAbs,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    LaunchedEffect(downloadProgressAbs) {
        while (downloadProgressAbs < 1f) {
            delay(1000L)
            downloadProgressAbs += 0.3f
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            color = MaterialTheme.colors.surface,
            progress = animatedDownloadProgressPush
        )
        Text(text = "An analize your BMI ...", color = MaterialTheme.colors.primary)
        Timer(navController = navController)                    //3 секундная задержка и переход на ofpScreen
    }


}

@Composable
fun Timer(navController: NavController) {
    var value by remember { mutableStateOf(3) }
    LaunchedEffect(Unit) {
        while (value > 0) {
            delay(1000)
            value -= 1
        }
        navController.navigate(Routers.OFP.route)
    }
}
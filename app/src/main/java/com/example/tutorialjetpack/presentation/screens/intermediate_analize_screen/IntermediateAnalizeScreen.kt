package com.example.tutorialjetpack.presentation.screens.intermediate_analize_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Surface
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.utils.Routers
import kotlinx.coroutines.delay

@Composable
fun IntermediateAnalizeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.background_gradient),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.4f
        )
        var downloadProgressPush by remember { mutableStateOf(0.1f) }
        var downloadProgressPull by remember { mutableStateOf(0.1f) }
        var downloadProgressAbs by remember { mutableStateOf(0.1f) }
        val animatedDownloadProgressPush by animateFloatAsState(
            targetValue = downloadProgressPush,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        val animatedDownloadProgressPull by animateFloatAsState(
            targetValue = downloadProgressPull,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        val animatedDownloadProgressAbs by animateFloatAsState(
            targetValue = downloadProgressAbs,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )

        LaunchedEffect(downloadProgressPush) {
            while (downloadProgressPush < 0.7f) {
                delay(200L)
                downloadProgressPush += 0.1f
            }
        }

        LaunchedEffect(downloadProgressPull) {
            while (downloadProgressPull < 0.4f) {
                delay(200L)
                downloadProgressPull += 0.1f
            }
        }

        LaunchedEffect(downloadProgressAbs) {
            while (downloadProgressAbs < 0.9f) {
                delay(200L)
                downloadProgressAbs += 0.1f
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {

                Column() {
                    Text(text = "Push up", color = MaterialTheme.colors.primary)
                    Text(text = "Pull up", color = MaterialTheme.colors.primary)
                    Text(text = "Squats", color = MaterialTheme.colors.primary)
                    Text(text = "Sit up", color = MaterialTheme.colors.primary)
                    Text(text = "Back extension", color = MaterialTheme.colors.primary)
                }
                Column() {
                    LinearProgressIndicator(
                        animatedDownloadProgressPush,
                        color = MaterialTheme.colors.surface,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(10.dp)
                    )
                    LinearProgressIndicator(
                        animatedDownloadProgressPull,
                        color = MaterialTheme.colors.surface,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(8.dp)
                    )
                    LinearProgressIndicator(
                        animatedDownloadProgressAbs,
                        color = MaterialTheme.colors.surface,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(8.dp)
                    )
                    LinearProgressIndicator(
                        animatedDownloadProgressPull,
                        color = MaterialTheme.colors.surface,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(8.dp)
                    )
                    LinearProgressIndicator(
                        animatedDownloadProgressPush,
                        color = MaterialTheme.colors.surface,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Text(
                text = "Your results are more than 70% of users!",
                modifier = Modifier.padding(top = 10.dp),
                color = MaterialTheme.colors.primary
            )
            Timer(navController = navController)


//            Button(
//                onClick = {
//                    navController.navigate(Routers.TRAINING.route)
//                },
//                modifier = Modifier.padding(top = 10.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//            ) {
//                Text(text = "create training", color = MaterialTheme.colors.primary)
//            }
        }
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
        navController.navigate(Routers.TRAINING.route)
    }
}
package com.example.tutorialjetpack.presentation.screens.intermediate_analize_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.utils.Routers

@Composable
fun IntermediateAnalizeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {

                Column() {
                    Text(text = "Push up")
                    Text(text = "Pull up")
                    Text(text = "Squats")
                    Text(text = "Sit up")
                    Text(text = "Back extension")
                }
                Column() {
                    LinearProgressIndicator(0.7f, color = Color.Red, backgroundColor = Color.White, modifier = Modifier.padding(10.dp))
                    LinearProgressIndicator(0.5f, color = Color.Red, backgroundColor = Color.White, modifier = Modifier.padding(8.dp))
                    LinearProgressIndicator(0.8f, color = Color.Red, backgroundColor = Color.White, modifier = Modifier.padding(8.dp))
                    LinearProgressIndicator(0.7f, color = Color.Red, backgroundColor = Color.White, modifier = Modifier.padding(8.dp))
                    LinearProgressIndicator(0.6f, color = Color.Red, backgroundColor = Color.White, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Your results are more than 70% of users!", modifier = Modifier.padding(top = 10.dp))
            Button(onClick = { navController.navigate(Routers.TRAINING.route)}, modifier = Modifier.padding(top = 10.dp)) {
                Text(text = "create training")
            }
        }
    }
}
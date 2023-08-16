package com.example.tutorialjetpack.presentation.screens.training_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun TrainingRepair(navController: NavController) {
    var value by remember { mutableStateOf(3) }
    LaunchedEffect(Unit) {
        while (value > 0) {
            delay(1000)
            value -= 1
        }
        navController.popBackStack()
    }
}
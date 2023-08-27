package com.example.tutorialjetpack.presentation.screens.training_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun TimerTrainingRepair(
    value1: Int
) {
    var value by remember { mutableStateOf(value1) }
    LaunchedEffect(key1 = value) {
        while (value > 0) {
            delay(1000)
            value -= 1
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "your rest: ${value}", color = Color.Black, fontSize = 24.sp)
        Button(
            onClick = { value += 20 },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(text = "+ 20 sec", color = MaterialTheme.colors.primary)
        }
    }
}
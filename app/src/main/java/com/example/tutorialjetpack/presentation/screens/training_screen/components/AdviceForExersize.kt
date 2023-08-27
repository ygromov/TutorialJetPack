package com.example.tutorialjetpack.presentation.screens.training_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdviceForExersize() {
    Card(modifier = Modifier
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        .background(MaterialTheme.colors.background)
        .alpha(0.7f)) {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .alpha(0.7f)) {
            Text(text = "Advice: ", fontSize = 20.sp, textAlign = TextAlign.Center)
            Text(text = "Before training, do a good warm-up, as warmed up muscles increase the efficiency of the workout.")
        }
    }
}
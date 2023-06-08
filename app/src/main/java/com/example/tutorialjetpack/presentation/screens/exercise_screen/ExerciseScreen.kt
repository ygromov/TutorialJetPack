package com.example.tutorialjetpack.presentation.screens.exercise_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.presentation.screens.exercise_screen.components.ExerciseItem

@Composable
fun ExerciseScreen(
    state: ExerciseState,
    navController: NavController
) {
    Column() {
        ExerciseItem(exercise = state.list)

        Button(
            modifier = Modifier.padding(5.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            ),
            onClick = { navController.popBackStack() }) {
            Text(text = "back")
        }
    }
}
//error commit
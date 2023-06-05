package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

private const val TAG = "TrainingScreen"
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TrainingScreen(navController: NavController) {         //вот сюда передали

    Scaffold() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Log.d(TAG, "TrainingScreen: ")
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
            Text(text = "kvjnrkbjve")
        }

    }
}
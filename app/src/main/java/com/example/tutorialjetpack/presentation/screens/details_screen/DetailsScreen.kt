package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController) {         //вот сюда передали

    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background) {

        Column() {
            Text(text = "Здесь будет изменение веса, роста, возраста")
            Button(
                modifier = Modifier.padding(5.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { navController.popBackStack() },

                ) {
                Text(
                    text = "back"
                )
            }
        }
    }
}
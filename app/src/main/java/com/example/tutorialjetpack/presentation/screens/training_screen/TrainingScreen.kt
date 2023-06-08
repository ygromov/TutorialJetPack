package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.presentation.screens.ProgressBar
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState

private const val TAG = "TrainingScreen"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TrainingScreen(state: TrainingState, navController: NavController, onEvent: (TrainingEvent) -> Unit,) {         //вот сюда передали

    Scaffold {

        Column(
            modifier = Modifier.fillMaxWidth(),
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {

            ProgressBar()

            Text(text = state.headText, modifier = Modifier.padding(top = 20.dp), textAlign = TextAlign.Center)

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                Text(text = "Push Up")
                Text(text = state.push.toString())
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Pull Up")
                Text(text = state.pull.toString())
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Squat")
                Text(text = state.squat.toString())
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Abc")
                Text(text = state.abc.toString())
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Extens")
                Text(text = state.extens.toString())
            }

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
                onClick = { onEvent.invoke(TrainingEvent.CompleteSet) }) {
                Text(text = "Complete")
            }

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
}
//error commit
package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.presentation.screens.details_screen.DetailsScreenEvent
import com.example.tutorialjetpack.presentation.screens.details_screen.DetailsState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(state: DetailsState, onEvent: (DetailsScreenEvent) -> Unit) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Card(modifier = Modifier
                    .size(100.dp)
                    .padding(start = 16.dp), elevation = 8.dp) {
                    Box(modifier = Modifier.background(Color.White))
                }
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = "name: ${state.name}", modifier = Modifier.padding(top = 4.dp))
                    Text(text = "age: ${state.age}", modifier = Modifier.padding(top = 4.dp))
                    Text(text = "height: ${state.height}", modifier = Modifier.padding(top = 4.dp))
                    Text(text = "weight: ${state.weight}", modifier = Modifier.padding(top = 4.dp))
                    Text(text = "gender: ${state.gender}", modifier = Modifier.padding(top = 4.dp))
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp)
            ) {
                Text(text = "my repetitions piggy bank:")
                Card(elevation = 8.dp) {
                    Text(text = "push ups: ${state.push}")
                }
                Card(elevation = 8.dp) {
                    Text(text = "pull ups: ${state.push}")
                }
                Card(elevation = 8.dp) {
                    Text(text = "squats: ${state.push}")
                }
                Card(elevation = 8.dp) {
                    Text(text = "sit s: ${state.push}")
                }
                Card(elevation = 8.dp) {
                    Text(text = "back extensions: ${state.push}")
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),

                ) {
                Button(onClick = { onEvent.invoke(DetailsScreenEvent.ToOfpScreen)}) {
                    Text(text = "OfpTest")
                }
                Button(onClick = { }) {
                    Text(text = "Training")
                }

                Button(onClick = { }) {
                    Text(text = "Journal")
                }
            }
        }
    }
}

package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp),

                ) {
                Button(elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.primary
                    ), onClick = { onEvent.invoke(DetailsScreenEvent.ToOfpScreen) }) {
                    Text(text = "OfpTest")
                }
                Button(elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.primary
                    ), onClick = { onEvent.invoke(DetailsScreenEvent.ToTrainingScreen) }) {
                    Text(text = "Training")
                }

                Button(elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.primary
                    ), onClick = { onEvent.invoke(DetailsScreenEvent.ToJournalScreen) }) {
                    Text(text = "Journal")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(start = 16.dp), elevation = 8.dp
                ) {
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
                Text(text = "my Ofp goal:")
                Row() {
                    Card(modifier = Modifier
                        .width(80.dp)
                        .height(20.dp)) {
                        Text(text = "pull ups: ")
                    }

                    LinearProgressIndicator(
                        progress = state.pull.toFloat() / (state.pull + 2),
                        color = Color.Red,
                        backgroundColor = Color.White,
                        modifier = Modifier.fillMaxHeight(0.015f).align(Alignment.CenterVertically)
                    )
                    Text(text = "${state.pull} / ${state.pull + 2}")
                    //will add a result of analizeMax
                }
                Row() {
                    Card(modifier = Modifier
                        .width(80.dp)
                        .height(20.dp)) {
                        Text(text = "push ups: ")
                    }
                    LinearProgressIndicator(
                        progress = state.push.toFloat() / (state.push + 5),
                        color = Color.Red,
                        backgroundColor = Color.White,
                        modifier = Modifier.fillMaxHeight(0.015f).align(Alignment.CenterVertically)
                    )
                    Text(text = "${state.push} / ${state.push + 5}")
                    //will add a result of analizeMax
                }
                Row() {
                    Card(modifier = Modifier
                        .width(80.dp)
                        .height(20.dp)) {
                        Text(text = "squats: ")
                    }
                    LinearProgressIndicator(
                        progress = state.squat.toFloat() / (state.squat + 7),
                        color = Color.Red,
                        backgroundColor = Color.White,
                        modifier = Modifier.fillMaxHeight(0.015f).align(Alignment.CenterVertically)
                    )
                    Text(text = "${state.squat} / ${state.squat + 7}")
                    //will add a result of analizeMax
                }
                Row() {
                    Card(modifier = Modifier
                        .width(80.dp)
                        .height(20.dp)) {
                        Text(text = "sit ups: ")
                    }
                    LinearProgressIndicator(
                        progress = state.abs.toFloat() / (state.abs + 10),
                        color = Color.Red,
                        backgroundColor = Color.White,
                        modifier = Modifier.fillMaxHeight(0.015f).align(Alignment.CenterVertically)
                    )
                    Text(text = "${state.abs} / ${state.abs + 10}")
                    //will add a result of analizeMax
                }
                Row() {
                    Card(modifier = Modifier
                        .width(80.dp)
                        .height(20.dp)) {
                        Text(text = "back ext: ")
                    }
                    LinearProgressIndicator(
                        progress = state.extens.toFloat() / (state.extens + 10),
                        color = Color.Red,
                        backgroundColor = Color.White,
                        modifier = Modifier.fillMaxHeight(0.015f).align(Alignment.CenterVertically)
                    )
                    Text(text = "${state.extens} / ${state.extens + 10}")
                    //will add a result of analizeMax
                }
            }


        }
    }
}

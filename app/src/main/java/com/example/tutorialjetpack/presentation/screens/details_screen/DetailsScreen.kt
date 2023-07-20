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
import androidx.compose.ui.unit.sp
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
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = MaterialTheme.colors.primary
                    ), onClick = { onEvent.invoke(DetailsScreenEvent.ToOfpScreen) }) {
                    Column() {
                        Text(text = "OfpTest")
                        //Text(text = "Change you results", Modifier.size(2.dp))
                    }

                }
                Button(elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = MaterialTheme.colors.primary
                    ), onClick = { onEvent.invoke(DetailsScreenEvent.ToTrainingScreen) }) {
                    Text(text = "Training")
                }

                Button(elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "my Ofp goal:")
                    Text(text = "My/Goal")
                }
                Row() {
                    Card(
                        modifier = Modifier
                            .width(70.dp)
                            .height(20.dp)
                    ) {
                        Text(
                            text = "pull ups: ",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary)
                        )
                    }

                    LinearProgressIndicator(
                        progress = state.pull.toFloat() / (state.pullGoal),
                        color = Color.Red,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .fillMaxHeight(0.015f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "${state.pull} / ${state.pullGoal}",
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                    //will add a result of analizeMax
                }
                Row() {
                    Card(
                        modifier = Modifier
                            .width(70.dp)
                            .height(20.dp)
                    ) {
                        Text(
                            text = "push ups: ",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary)
                        )
                    }
                    LinearProgressIndicator(
                        progress = state.push.toFloat() / (state.pushGoal),
                        color = Color.Red,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .fillMaxHeight(0.015f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "${state.push} / ${state.pushGoal}",
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                    //will add a result of analizeMax
                }
                Row() {
                    Card(
                        modifier = Modifier
                            .width(70.dp)
                            .height(20.dp)
                    ) {
                        Text(
                            text = "squats: ",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary)
                        )
                    }
                    LinearProgressIndicator(
                        progress = state.squat.toFloat() / (state.squatGoal),
                        color = Color.Red,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .fillMaxHeight(0.015f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "${state.squat} / ${state.squatGoal}",
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                    //will add a result of analizeMax
                }
                Row() {
                    Card(
                        modifier = Modifier
                            .width(70.dp)
                            .height(20.dp)
                    ) {
                        Text(
                            text = "sit ups: ",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary)
                        )
                    }
                    LinearProgressIndicator(
                        progress = state.abs.toFloat() / (state.absGoal),
                        color = Color.Red,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .fillMaxHeight(0.015f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "${state.abs} / ${state.absGoal}",
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                    //will add a result of analizeMax
                }
                Row() {
                    Card(
                        modifier = Modifier
                            .width(70.dp)
                            .height(20.dp)
                    ) {
                        Text(
                            text = "back ext: ",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary)
                        )
                    }
                    LinearProgressIndicator(
                        progress = state.extens.toFloat() / (state.extensGoal),
                        color = Color.Red,
                        backgroundColor = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .fillMaxHeight(0.015f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "${state.extens} / ${state.extensGoal}",
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                    //will add a result of analizeMax
                }
            }


        }
    }
}

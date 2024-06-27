package com.example.tutorialjetpack.presentation.screens.training_screen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState

@SuppressLint("UnrememberedMutableState")
@Composable
fun TestNormal(
    state: TrainingState,
    //onEvent: (TrainingEvent) -> Unit,
    isCompleted: Boolean,
    onCompleteClick: () -> Unit,
    countS: Int,
    allowButtonClick: Boolean, // Флаг, разрешающий нажатие на кнопку
) {
    /*
        primary = White900,            //text
        primaryVariant = Black610,   //button
        secondary = Grey100,        //field
        background = White900,        //background
        surface = Grey350
     */

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(start = 4.dp, top = 32.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.weight(1f),
                backgroundColor =
                if (countS == 1) {
                    MaterialTheme.colors.primaryVariant
                } else MaterialTheme.colors.surface

            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = state.pull.toString(),
                        modifier = Modifier.padding(5.dp),
                    )
                    Text(
                        text = " pulls",
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.h6,
                    )
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                backgroundColor =
            if (countS == 2) {
                MaterialTheme.colors.primaryVariant
            } else MaterialTheme.colors.surface
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = state.push.toString(),
                        modifier = Modifier.padding(5.dp),
                    )
                    Text(
                        text = " pushs",
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.h6,
                    )
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                backgroundColor =
            if (countS == 3) {
                MaterialTheme.colors.primaryVariant
            } else MaterialTheme.colors.surface) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = state.squat.toString()
                )
                    Text(
                        modifier = Modifier
                            .padding(5.dp),
                        style = MaterialTheme.typography.h6,
                        text = " squats"
                    )
            }}
            Card(
                modifier = Modifier.weight(1f),
                backgroundColor =
            if (countS == 4) {
                MaterialTheme.colors.primaryVariant
            } else MaterialTheme.colors.surface) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = state.abc.toString()
                )
                    Text(
                        modifier = Modifier
                            .padding(5.dp),
                        style = MaterialTheme.typography.h6,
                        text = " abs"
                    )
            }}
            Card(
                modifier = Modifier.weight(1f),
                backgroundColor =
            if (countS == 5) {
                MaterialTheme.colors.primaryVariant
            } else MaterialTheme.colors.surface) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = state.extens.toString()
                )
                    Text(
                        modifier = Modifier
                            .padding(5.dp),
                        style = MaterialTheme.typography.h6,
                        text = " extens"
                    )
            }}
        }

            Column(
                modifier = Modifier.padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (countS) { // Используем when для большей читаемости
                    1 -> GifTraining(data = R.drawable.pullupgifs)
                    2 -> GifTraining(data = R.drawable.pushups)
                    3 -> GifTraining(data = R.drawable.squatsgif)
                    4 -> GifTraining(data = R.drawable.situpsgif)
                    5 -> GifTraining(data = R.drawable.extens)
                }

                Button(
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .width(100.dp)
                        .height(35.dp),
                    onClick = onCompleteClick,                  //кнопка отправляет свое действие
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black
                    ),
                    enabled = allowButtonClick, // Используем переданный флаг

                ) {
                    Text(text = "done")

                }
            }
        }
    }

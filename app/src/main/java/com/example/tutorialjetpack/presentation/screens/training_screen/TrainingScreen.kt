package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState
import com.example.tutorialjetpack.utils.Routers

private const val TAG = "TrainingScreen"

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@SuppressLint("UnrememberedMutableState")
@Composable
fun TrainingScreen(
    state: TrainingState,
    navController: NavController,
    onEvent: (TrainingEvent) -> Unit,
) {         //вот сюда передали
    var name = mutableStateOf("Pull ups")
    var reps = mutableStateOf("${state.pull}"  +  " reps")
    val image = mutableStateOf(R.drawable.pullup)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello, ${state.name}", fontSize = 24.sp)
            //ProgressBar()

            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp),
                text = state.headText, fontSize = 20.sp
            )
            Card(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
                    , elevation = 8.dp
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                    .background(MaterialTheme.colors.background)
                ) {
                    Text(text = name.value, fontSize = 20.sp)
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(MaterialTheme.colors.background),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(painter = painterResource(id = image.value), contentDescription = "")

                    }
                    Text(text = "${reps.value}")
                    Box(modifier = Modifier
                        .size(50.dp)
                        .padding(top = 8.dp)
                        .background(Color.Black)){
                        Text(text = "60", fontSize = 28.sp, color = Color.White)
                        //auto timer for repair
                        //depends of a user result
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                            contentColor = MaterialTheme.colors.primary
                        ),
                        onClick = {
                        if (name.value == "Pull ups") {
                            name.value = "Push ups"
                            reps.value = state.push.toString() +  " reps"
                            image.value = R.drawable.pushup
                        } else if (name.value == "Push ups") {
                            name.value = "Squats"
                            reps.value = state.squat.toString() +  " reps"
                            image.value = R.drawable.squats
                        } else if (name.value == "Squats") {
                            name.value = "Sit ups"
                            reps.value = state.abc.toString() +  " reps"
                            image.value = R.drawable.situps
                        } else if (name.value == "Sit ups") {
                            name.value = "Back extensions"
                            reps.value = state.extens.toString() +  " reps"
                            image.value = R.drawable.extens
                        } else if (name.value == "Back extensions") {
                            name.value = "Congrats"
                            reps.value = "Your are amazing!"
                            image.value = R.drawable.complete
                        } else if (name.value == "Congrats") {
                            if (state.headText == "1 set") {
                                onEvent.invoke(TrainingEvent.TwoSet)
                                //вызов ивента, который вызывает создание предыдущей
                                //тренировки и прибавляет к sumPush, sumPull etc
                            } else if (state.headText == "2 set") {
                                onEvent.invoke(TrainingEvent.ThreeSet)
                            } else if (state.headText == "3 set") {
                                onEvent.invoke(TrainingEvent.FourSet)
                            } else if (state.headText == "4 set") {
                                navController.navigate(Routers.DETAILS.route)
                                onEvent.invoke(TrainingEvent.TrainingCount)
                            }
                        }
                    }) {
                        Text(text = "complete")
                    }
                }
            }

            Button(
                modifier = Modifier.padding(start = 4.dp, top = 10.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { navController.navigate(Routers.DETAILS.route) }) {
                Text(text = "to Home")
            }
        }
    }
}
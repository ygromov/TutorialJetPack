package com.example.tutorialjetpack.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.ProgressBar
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState

private const val TAG = "TrainingScreen"

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TrainingScreen(
    state: TrainingState,
    navController: NavController,
    onEvent: (TrainingEvent) -> Unit,
) {         //вот сюда передали

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProgressBar()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
                    onClick = { onEvent.invoke(TrainingEvent.OneSet) }) {
                    Text(text = "1 set")
                }

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
                    onClick = { onEvent.invoke(TrainingEvent.TwoSet) }) {
                    Text(text = "2 set")
                }

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
                    onClick = { onEvent.invoke(TrainingEvent.ThreeSet) }) {
                    Text(text = "3 set")
                }

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
                    onClick = { onEvent.invoke(TrainingEvent.FourSet) }) {
                    Text(text = "4 set")

                }
            }

            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp), text = state.headText
            )

            Card(modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp).background(MaterialTheme.colors.secondary)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp4),
                        contentDescription = "ic_test_training"
                    )
                    Text(text = "Push Up")
                    Text(text = state.push.toString())
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, top = 8.dp, end = 10.dp).background(MaterialTheme.colors.secondary)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp4),
                        contentDescription = "ic_test_training"
                    )
                    Text(text = "Pull Up")
                    Text(text = state.pull.toString())
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, top = 8.dp, end = 10.dp).background(MaterialTheme.colors.secondary)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp4),
                        contentDescription = "ic_test_training"
                    )
                    Text(text = "Squat")
                    Text(text = state.squat.toString())
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, top = 8.dp, end = 10.dp).background(MaterialTheme.colors.secondary)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp4),
                        contentDescription = "ic_test_training"
                    )
                    Text(text = "Abs")
                    Text(text = state.abc.toString())
                }
            }
            Card(modifier = Modifier.padding(start = 10.dp, top = 8.dp, end = 10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                        .padding(start = 20.dp, end = 20.dp)
                        ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp4),
                        contentDescription = "ic_test_training"
                    )
                    Text(text = "Extens")
                    Text(text = state.extens.toString())
                }
            }


            Button(
                modifier = Modifier.padding(start = 4.dp, top = 10.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { navController.popBackStack() }) {
                Text(text = "back")
            }
        }
    }
}
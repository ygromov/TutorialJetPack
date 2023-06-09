package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.domain.model.MonthValue


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JournalScreen(navController: NavController, state:MonthValue) {         //вот сюда передали

    Scaffold() {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(text = state.created)
                Text(text = "push")
                Text(text =state.maxPush.toString() )
                Text(text = "pull")
                Text(text = state.maxPull.toString())
                Text(text = "squat")
                Text(text = state.maxSquat.toString())
                Text(text = "abc")
                Text(text = state.maxAbc.toString())
                Text(text = "extens")
                Text(text = state.maxExtens.toString())
            }



            Card(modifier = Modifier.fillMaxWidth()) {
                Text(text = "February")
            }
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(text = "March")
            }
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(text = "April")
            }
            Card(modifier = Modifier.fillMaxWidth()) {
                Text(text = "May")
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
                onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "back")
            }
        }
    }
}//error commit
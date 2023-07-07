package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.domain.model.MonthValue


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JournalScreen(navController: NavController, state: MonthValue) {         //вот сюда передали

    Scaffold() {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(modifier = Modifier.padding(top = 16.dp), text = "Your top score:")

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = state.created)

                Text(modifier = Modifier.padding(top=8.dp), text = "Push ups: ${ state.maxPush.toString() }")

                Text(modifier = Modifier.padding(top=8.dp),text = "Pull ups: ${state.maxPull.toString()}")

                Text(modifier = Modifier.padding(top=8.dp),text = "Squats: ${state.maxSquat.toString()}")

                Text(modifier = Modifier.padding(top=8.dp),text = "Sit ups: ${state.maxAbc.toString()}")

                Text(modifier = Modifier.padding(top=8.dp),text = "Back extension: ${state.maxExtens.toString()}")
            }

            Button(
                modifier = Modifier.padding(16.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "back")
            }
        }
    }
}
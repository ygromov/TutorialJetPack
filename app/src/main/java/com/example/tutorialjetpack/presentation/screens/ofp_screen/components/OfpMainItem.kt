package com.example.tutorialjetpack.presentation.screens.ofp_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpScreenEvent

@Composable
fun OfpMainItem(
    onEvent:(OfpScreenEvent) -> Unit
//    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            //.background(color = Color.Gray)
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
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
            onClick = {
                onEvent.invoke(OfpScreenEvent.BtnTraining)
//                navController.navigate(Routers.TRAINING.route)
            }) {
            Text(text = "Training")
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
            onClick = {
                onEvent.invoke(OfpScreenEvent.BtnJournal)
//                navController.navigate(Routers.JOURNAL.route)
            }) {
            Text(text = "Journal")
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
            onClick = {
                onEvent.invoke(OfpScreenEvent.BtnDetails)
            }) {
            Text(text = "details")
        }

    }
}
//error commit
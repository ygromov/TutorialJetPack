package com.example.tutorialjetpack.presentation.screens.first_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorialjetpack.domain.model.GoalListModel

@Composable
fun GoalItem() {
    val list = mutableListOf<GoalListModel>()
    list.add(
        GoalListModel(
            fatBurnGoal = "FatBurn",
            powerGoal = "Body strength",
            muscleMaxGoal = "Muscle building",

            bodyweight = "BodyWeight",
            freeWeight = "Free weight",
            withSimulators = "Simulators"
        )
    )
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp, top = 16.dp, end = 8.dp)
            .fillMaxWidth()
    ) {
        items(list) {
            Goal(goalList = it)
        }
    }
}

@Composable
fun Goal(goalList: GoalListModel) {
    Row {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.secondary,
            modifier = Modifier.size(300.dp, 350.dp),
            elevation = 8.dp
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = goalList.fatBurnGoal, textAlign = TextAlign.Center, fontSize = 24.sp)
                Text(text = "fat burning workout")
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.bodyweight)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.freeWeight)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.withSimulators)
                }
            }

        }
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.secondary,
            modifier = Modifier
                .size(300.dp, 350.dp)
                .padding(start = 8.dp),
            elevation = 8.dp
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = goalList.powerGoal, textAlign = TextAlign.Center, fontSize = 24.sp)
                Text(text = "to strengthen the body")
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.bodyweight)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.freeWeight)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.withSimulators)
                }
            }
        }

        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.secondary,
            modifier = Modifier
                .size(300.dp, 350.dp)
                .padding(start = 8.dp),
            elevation = 8.dp
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = goalList.muscleMaxGoal, textAlign = TextAlign.Center, fontSize = 24.sp)
                Text(text = "for muscle building")
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.bodyweight)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.freeWeight)
                }
                Button(colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),onClick = { /*TODO*/ }) {
                    Text(text = goalList.withSimulators)
                }
            }
        }
    }
}
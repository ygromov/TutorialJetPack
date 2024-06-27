package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.MonthValue
import com.example.tutorialjetpack.utils.Routers


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JournalScreen(navController: NavController, state: MonthValue) {         //вот сюда передали

    var profileVisible by remember { mutableStateOf(true) }
    var settingsVisible by remember { mutableStateOf(false) }

    Scaffold() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)) {
                Button(
                    onClick = {
                    profileVisible = true
                    settingsVisible = false
                },
                Modifier.fillMaxWidth(0.5f).padding(top = 16.dp, end = 8.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 16.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = MaterialTheme.colors.primary
                    ),) {
                    Text(text = "Profile")
                }
                Button(onClick = {
                    profileVisible = false
                    settingsVisible = true
                },Modifier.fillMaxWidth(1f).padding(top = 16.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 16.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = MaterialTheme.colors.primary
                    ),) {
                    Text(text = "Settings")
                }
            }
            if (profileVisible) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .background(MaterialTheme.colors.primaryVariant),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "name",
                        color = MaterialTheme.colors.primary)
                    Text(text = "height",
                        color = MaterialTheme.colors.primary)
                    Text(text = "weight",
                        color = MaterialTheme.colors.primary)
                    Text(text = "year",
                        color = MaterialTheme.colors.primary)
                    Text(text = "level",
                        color = MaterialTheme.colors.primary)
                    Text(text = "active",
                        color = MaterialTheme.colors.primary)
                    Text(text = "body",
                        color = MaterialTheme.colors.primary)
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .background(MaterialTheme.colors.primaryVariant),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = "Themes",
                        color = MaterialTheme.colors.primary)
                    Text(text = "Language",
                        color = MaterialTheme.colors.primary)

                }
            }

            Button(
                modifier = Modifier.padding(16.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "back", color = MaterialTheme.colors.primary)
            }
//            Button(onClick = {navController.navigate(Routers.EXERCISE.route) }) {
//                Text(text = "test")
//            }

        }
    }
}
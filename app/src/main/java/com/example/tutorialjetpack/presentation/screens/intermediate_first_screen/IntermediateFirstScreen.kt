package com.example.tutorialjetpack.presentation.screens.intermediate_first_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tutorialjetpack.utils.Routers
import kotlinx.coroutines.delay

@Composable
fun IntermediateFirstScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator()
        Text(text = "An analize your BMI ...")
        Timer(navController = navController)                    //3 секундная задержка и переход на ofpScreen
    }


}

@Composable
fun Timer(navController: NavController) {
    var value by remember { mutableStateOf(3) }
    LaunchedEffect(Unit) {
        while (value > 0) {
            delay(1000)
            value -= 1
        }
        navController.navigate(Routers.OFP.route)
    }

}
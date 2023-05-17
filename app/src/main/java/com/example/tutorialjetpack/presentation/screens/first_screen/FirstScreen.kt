package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tutorialjetpack.utils.Routers


@Composable
fun FirstScreen(imtState: ImtState,onEvent:(FirstScreenEvent)->Unit) {
//    val test = remember {
//        imtState
//    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Male")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Female")
            }
        }
        TextField(value = imtState.age.toString(), onValueChange = { age->
            onEvent.invoke(FirstScreenEvent.ChangeAge(age.toInt()))
//            test.age = it
        })
        TextField(value = imtState.height.toString(), onValueChange = {
            onEvent.invoke(FirstScreenEvent.ChangeHeight(it.toInt()))
//            imtState.height = it
        })
        TextField(value = imtState.weight.toString(), onValueChange = {
            onEvent.invoke(FirstScreenEvent.ChangeWeight(it.toInt()))
//            imtState.weight = it
        })

        OutlinedButton(onClick = {
//            navController.navigate(Routers.OFP.route)
            onEvent.invoke(FirstScreenEvent.Complete)
        }) {
            Text(text = "Complete")
        }
    }
}
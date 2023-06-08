package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.tutorialjetpack.data.datastore.AppDataStoreManager


@Composable
fun FirstScreen(
    imtState: ImtState,
    onEvent: (FirstScreenEvent) -> Unit,
    appDataStoreManager: AppDataStoreManager
) {
//    val test = remember {
//        imtState
//    }
    //val coroutine = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(onClick = { onEvent.invoke(FirstScreenEvent.ChangeGender("male")) }) {
                Text(text = "Male")
            }
            OutlinedButton(onClick = { onEvent.invoke(FirstScreenEvent.ChangeGender("female")) }) {
                Text(text = "Female")
            }
        }
        TextField(
            value = imtState.name, onValueChange = {
                onEvent.invoke(FirstScreenEvent.ChangeName(it))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = imtState.age, onValueChange = { age ->
                onEvent.invoke(FirstScreenEvent.ChangeAge(age))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = imtState.height, onValueChange = {
                onEvent.invoke(FirstScreenEvent.ChangeHeight(it))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = imtState.weight, onValueChange = {
                onEvent.invoke(FirstScreenEvent.ChangeWeight(it))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedButton(onClick = {
            onEvent.invoke(FirstScreenEvent.Complete)
        })
        {
            Text(text = "Complete")
        }
    }
}
//error commit
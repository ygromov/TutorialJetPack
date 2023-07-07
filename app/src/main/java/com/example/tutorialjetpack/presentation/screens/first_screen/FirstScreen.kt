package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.data.datastore.AppDataStoreManager
import com.example.tutorialjetpack.presentation.screens.first_screen.components.GoalItem


@Composable
fun FirstScreen(
    imtState: ImtState,
    onEvent: (FirstScreenEvent) -> Unit,
    appDataStoreManager: AppDataStoreManager
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                modifier = Modifier.padding(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { onEvent.invoke(FirstScreenEvent.ChangeGender("male")) }) {
                Text(text = "Male")
            }
            OutlinedButton(
                modifier = Modifier.padding(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = MaterialTheme.colors.primary
                ),
                onClick = { onEvent.invoke(FirstScreenEvent.ChangeGender("female")) }) {
                Text(text = "Female")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "name")
            Card(
                // modifier = Modifier.padding(start = 8.dp, end = 160.dp)
            ) {

                TextField(
                    value = imtState.name,
                    onValueChange = {
                        onEvent.invoke(FirstScreenEvent.ChangeName(it))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colors.primary,
                        backgroundColor = MaterialTheme.colors.secondary
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "age")
            TextField(
                value = imtState.age, onValueChange = { age ->
                    onEvent.invoke(FirstScreenEvent.ChangeAge(age))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.primary,
                    backgroundColor = MaterialTheme.colors.secondary
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "height")
            TextField(
                value = imtState.height, onValueChange = {
                    onEvent.invoke(FirstScreenEvent.ChangeHeight(it))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.primary,
                    backgroundColor = MaterialTheme.colors.secondary
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "weight")
            TextField(
                value = imtState.weight, onValueChange = {
                    onEvent.invoke(FirstScreenEvent.ChangeWeight(it))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.primary,
                    backgroundColor = MaterialTheme.colors.secondary
                )
            )
        }
        GoalItem()

        OutlinedButton(
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            ),
            onClick = {
                onEvent.invoke(FirstScreenEvent.Complete)
            })
        {
            Text(text = "Complete")
        }

    }
}
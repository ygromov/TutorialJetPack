package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.data.datastore.AppDataStoreManager


@Composable
fun FirstScreen(
    imtState: ImtState,
    onEvent: (FirstScreenEvent) -> Unit,
    appDataStoreManager: AppDataStoreManager
) {
    var isPress by remember { mutableStateOf(false) }       //for button
    var isPressed by remember { mutableStateOf(false) }

    var low by remember { mutableStateOf("Low") }
    var normal by remember { mutableStateOf("Normal") }
    var pro by remember { mutableStateOf("Pro") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Choose your gender:", modifier = Modifier.padding(top = 8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            var isMaleSelected by remember { mutableStateOf(false) }
            var isFemaleSelected by remember { mutableStateOf(false) }

            Text(text = "Male")
            Checkbox(
                checked = isMaleSelected, onCheckedChange = { isChecked ->
                    if (isChecked) {
                        isMaleSelected = true
                        isFemaleSelected = false
                        onEvent.invoke(FirstScreenEvent.ChangeGender("male"))
                    }
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colors.primary,
                    uncheckedColor = MaterialTheme.colors.primaryVariant
                ),
                modifier = Modifier.padding(5.dp)
            )

            Text(text = "Female")

            Checkbox(
                checked = isFemaleSelected, onCheckedChange = { isChecked ->
                    if (isChecked) {
                        isFemaleSelected = true
                        isMaleSelected = false
                        onEvent.invoke(FirstScreenEvent.ChangeGender("female"))
                    }
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colors.primary,
                    uncheckedColor = MaterialTheme.colors.primaryVariant
                ),
                modifier = Modifier.padding(5.dp)
            )
        }
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = {
//                    onEvent.invoke(FirstScreenEvent.ChangeGender("male"))
//                }) {
//                Text(text = "Male")
//            }
//            OutlinedButton(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = { onEvent.invoke(FirstScreenEvent.ChangeGender("female")) }) {
//                Text(text = "Female")
//            }
//        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name")
            Card() {

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
            Text(text = "Age")
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
            Text(text = "Height")
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
            Text(text = "Weight")
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
        Text(text = "Choose your physique:", modifier = Modifier.padding(top = 12.dp))

        Row(

        ) {
            var selectedBody by remember { mutableStateOf("") }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = "Skinny")
                Checkbox(
                    checked = selectedBody == "skinny",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedBody = "skinny"
                            onEvent.invoke(FirstScreenEvent.ChangeBody("skinny"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                   // modifier = Modifier.padding(5.dp)
                )
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = "Normal")
                Checkbox(
                    checked = selectedBody == "normal",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedBody = "normal"
                            onEvent.invoke(FirstScreenEvent.ChangeBody("normal"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                    //modifier = Modifier.padding(5.dp)
                )
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = "Muscle")
                Checkbox(
                    checked = selectedBody == "muscle",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedBody = "muscle"
                            onEvent.invoke(FirstScreenEvent.ChangeBody("muscle"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                   // modifier = Modifier.padding(5.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = "Fat")
                Checkbox(
                    checked = selectedBody == "fat",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedBody = "fat"
                            onEvent.invoke(FirstScreenEvent.ChangeBody("fat"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                    //modifier = Modifier.padding(5.dp)

                )
            }

//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = { onEvent.invoke(FirstScreenEvent.ChangeBody("skinny")) }) {
//                Text(text = "Skinny")
//            }
//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = { onEvent.invoke(FirstScreenEvent.ChangeBody("normal")) }) {
//                Text(text = "Normal")
//            }
//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = { onEvent.invoke(FirstScreenEvent.ChangeBody("muscle")) }) {
//                Text(text = "Muscle")
//            }
//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = { onEvent.invoke(FirstScreenEvent.ChangeBody("fat")) }) {
//                Text(text = "Fat")
//            }
        }
        Text(text = "Your daily activity:")
        Row(verticalAlignment = Alignment.CenterVertically) {
            var isActiveSelected by remember { mutableStateOf(false) }
            var isTiredSelected by remember { mutableStateOf(false) }

            Checkbox(
                checked = isActiveSelected,
                onCheckedChange = { isChecked ->
                    if (isChecked) {
                        isActiveSelected = true
                        isTiredSelected = false
                        onEvent.invoke(FirstScreenEvent.ChangeActiv("active"))
                    }
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colors.primary,
                    uncheckedColor = MaterialTheme.colors.primaryVariant
                ),
                //modifier = Modifier.padding(5.dp)
            )
            Text(text = "Active")


            Checkbox(
                checked = isTiredSelected,
                onCheckedChange = { isChecked ->
                    if (isChecked) {
                        isTiredSelected = true
                        isActiveSelected = false
                        onEvent.invoke(FirstScreenEvent.ChangeActiv("tired"))
                    }
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colors.primary,
                    uncheckedColor = MaterialTheme.colors.primaryVariant
                ),
                //modifier = Modifier.padding(5.dp)
            )
            Text(text = "Tired")

        }
//        Row(verticalAlignment = Alignment.CenterVertically) {
//
//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = { onEvent.invoke(FirstScreenEvent.ChangeActiv("active")) }) {
//                Text(text = "Active")
//            }
//            OutlinedButton(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = {
//                    onEvent.invoke(FirstScreenEvent.ChangeActiv("tired"))
//
//                }) {
//                Text(text = "Tired")
//            }
//        }

        Text(text = "Rate your fitness level:")
        Row(verticalAlignment = Alignment.CenterVertically) {
            var selectedLevel by remember { mutableStateOf("") }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Checkbox(
                    checked = selectedLevel == "30",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedLevel = "30"
                            onEvent.invoke(FirstScreenEvent.ChangeActiv("30"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                    //modifier = Modifier.padding(5.dp)
                )
                Text(text = "Low")
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Checkbox(
                    checked = selectedLevel == "45",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedLevel = "45"
                            onEvent.invoke(FirstScreenEvent.ChangeActiv("45"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                    //modifier = Modifier.padding(5.dp)
                )
                Text(text = "Normal")
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Checkbox(
                    checked = selectedLevel == "60",
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedLevel = "60"
                            onEvent.invoke(FirstScreenEvent.ChangeActiv("60"))
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary,
                        uncheckedColor = MaterialTheme.colors.primaryVariant
                    ),
                    //modifier = Modifier.padding(5.dp)
                )
                Text(text = "PRO")
            }

        }

//        Row(verticalAlignment = Alignment.CenterVertically) {
//
//            Button(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = {
//                    low = "Low-pressed"
//                    onEvent.invoke(FirstScreenEvent.ChangeActiv("30"))
//                }) {
//                Text(text = low)
//            }
//            OutlinedButton(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = {
//                    normal = "Normal-pressed"
//                    onEvent.invoke(FirstScreenEvent.ChangeActiv("45"))
//
//                }) {
//                Text(text = normal)
//            }
//            OutlinedButton(
//                modifier = Modifier.padding(5.dp),
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = MaterialTheme.colors.primaryVariant,
//                    contentColor = MaterialTheme.colors.primary
//                ),
//                onClick = {
//                    pro = "PRO-pressed"
//                    onEvent.invoke(FirstScreenEvent.ChangeActiv("60"))
//
//                }) {
//                Text(text = pro)
//            }
//        }
        //GoalItem()

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
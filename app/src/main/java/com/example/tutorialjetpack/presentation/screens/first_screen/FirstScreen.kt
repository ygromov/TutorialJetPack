package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.data.datastore.AppDataStoreManager


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FirstScreen(
    imtState: ImtState,
    onEvent: (FirstScreenEvent) -> Unit,
    appDataStoreManager: AppDataStoreManager
) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.background_gradient),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 0.4f
    )
    var weightKg by remember { mutableStateOf(0) }
    var weightGrams by remember { mutableStateOf(0) }
    var weightLbs by remember { mutableStateOf(0) }
    var weightLbsGr by remember { mutableStateOf(0) }
    var isKgSelected by remember { mutableStateOf(true) }

    val kgRange = 15..250
    val gramsRange = 0..9

    val listStateKG = rememberLazyListState(50)
    val listStateGr = rememberLazyListState()
    var visibleWeight by remember { mutableStateOf(false) }

    var heightSm by remember { mutableStateOf(0) }
    val smRange = 60..250
    val listStateSm = rememberLazyListState(110)
    var visibleHeight by remember { mutableStateOf(false) }

    var age by remember { mutableStateOf(0) }
    val ageRange = 0..120
    val listStateAge = rememberLazyListState(18)
    var visibleAge by remember { mutableStateOf(false) }

    var textFieldValue by remember { mutableStateOf("") }
    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .clickable { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(MaterialTheme.colors.background),
            elevation = 8.dp,

        ) {
            Text(
                text = "Smart Workout", color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.background(MaterialTheme.colors.background),
                fontSize = 40.sp
            )
        }

        Card(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp
        ) {
            Row(

                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var isMaleSelected by remember { mutableStateOf(false) }
                var isFemaleSelected by remember { mutableStateOf(false) }

                Text(text = "Male", color = MaterialTheme.colors.primary)
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

                Text(text = "Female", color = MaterialTheme.colors.primary)

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
        }


        //-------------------------------------------------------------------------------------

        Card(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp
        ) {
        Row(
            modifier = Modifier
               //.fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
               //modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                TextField(
                    value = imtState.name,
                    onValueChange = {
                        onEvent.invoke(FirstScreenEvent.ChangeName(it))
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colors.primary,
                        backgroundColor = MaterialTheme.colors.background
                    ),
                    label = { Text(text = "Input your name") }
                )
            }
        }
        }
//.................................................................................................

        Card(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp
        ) {
            Column() {      //age,height,weight

            Column(horizontalAlignment = Alignment.CenterHorizontally) {      //age
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Age:", color = MaterialTheme.colors.primary)
                    Text(text = age.toString(), color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clickable {
                                visibleAge = !visibleAge
                            }
                    )
                }
                if (visibleAge) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentHeight()
                            .wrapContentSize(align = Alignment.Center)
                    ) {

                        Box(
                            modifier = Modifier
                                .size(height = 160.dp, width = 90.dp)
                                .background(MaterialTheme.colors.secondary)
                        ) {
                            LazyColumn(state = listStateAge) {
                                itemsIndexed(items = ageRange.toList()) { index, it ->
                                    WeightItem(
                                        text = "${it} year",
                                        isSelected = isKgSelected && age == it,
                                        onClick = {
                                            isKgSelected = true
                                            age = it
                                        }
                                    )
                                }
                            }
                        }
                    }
                        Button(onClick = {
                            val value = age.toString()
                            onEvent.invoke(FirstScreenEvent.ChangeAge(value))
                            visibleAge = false
                        },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.primaryVariant,
                                contentColor = MaterialTheme.colors.primary
                            ),
                        ) {
                            Text(text = "Complete", color = MaterialTheme.colors.primary)
                        }


                }
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Height:", color = MaterialTheme.colors.primary)
                    Text(text = "${heightSm}.$weightGrams", color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clickable {
                                visibleHeight = !visibleHeight
                            }
                    )
                }
                if (visibleHeight) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentHeight()
                            .wrapContentSize(align = Alignment.Center)
                    ) {

                        Box(
                            modifier = Modifier
                                .size(height = 160.dp, width = 90.dp)
                                .background(MaterialTheme.colors.secondary)
                        ) {
                            LazyColumn(state = listStateSm) {
                                itemsIndexed(items = smRange.toList()) { index, sm ->
                                    WeightItem(
                                        text = "${sm} sm",
                                        isSelected = isKgSelected && heightSm == sm,
                                        onClick = {
                                            isKgSelected = true
                                            heightSm = sm
                                        }
                                    )
                                }
                            }
                        }
                    }
                        Button(onClick = {
                            val value = ("${heightSm}")
                            onEvent.invoke(FirstScreenEvent.ChangeHeight(value))
                            visibleHeight = false
                        },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.primaryVariant,
                                contentColor = MaterialTheme.colors.primary
                            ),
                        ) {
                            Text(text = "Complete", color = MaterialTheme.colors.primary)
                        }


                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Weight:", color = MaterialTheme.colors.primary)
//            TextField(
//                value = imtState.weight, onValueChange = {
//                    onEvent.invoke(FirstScreenEvent.ChangeWeight(it))
//                },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                colors = TextFieldDefaults.textFieldColors(
//                    textColor = MaterialTheme.colors.primary,
//                    backgroundColor = MaterialTheme.colors.secondary
//                )
//            )
                    Text(text = "${weightKg.toString()}.$weightGrams", color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .clickable {
                                visibleWeight = !visibleWeight
                            }
                    )
                }
                if (visibleWeight) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentHeight()
                            .wrapContentSize(align = Alignment.CenterEnd)
                    ) {

                        Box(
                            modifier = Modifier
                                .size(height = 120.dp, width = 160.dp)
                                .background(MaterialTheme.colors.secondary)
                        ) {
                            LazyColumn(state = listStateKG) {
                                itemsIndexed(items = kgRange.toList()) { index, kg ->
                                    WeightItem(
                                        text = "${kg} kg",
                                        isSelected = isKgSelected && weightKg == kg,
                                        onClick = {
                                            isKgSelected = true
                                            weightKg = kg
                                        }
                                    )
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .size(height = 120.dp, width = 160.dp)
                                .background(MaterialTheme.colors.secondary)
                        ) {
                            LazyColumn(state = listStateGr) {
                                itemsIndexed(items = gramsRange.toList()) { index, gr ->
                                    WeightItem(
                                        text = "0.${gr}00",
                                        isSelected = isKgSelected && weightKg == gr,
                                        onClick = {
                                            isKgSelected = true
                                            weightGrams = gr
                                        }
                                    )
                                }
                            }


                        }
                    }
                        Button(onClick = {
                            val value = ("${weightKg}.$weightGrams")
                            onEvent.invoke(FirstScreenEvent.ChangeWeight(value))
                            visibleWeight = false
                        },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.primaryVariant,
                                contentColor = MaterialTheme.colors.primary
                            ),
                        ) {
                            Text(text = "Complete", color = MaterialTheme.colors.primary)
                        }


                }
            }
        }
        }
        //------------------------------------------------------------------------------------------

        //Text(text = "Choose your physique:", modifier = Modifier.padding(top = 12.dp))
        Card(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.padding(top = 16.dp)
                    ,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var selectedBody by remember { mutableStateOf("") }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
            ) {
                Text(text = "Skinny", color = MaterialTheme.colors.primary)
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
                Text(text = "Normal", color = MaterialTheme.colors.primary)
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
                Text(text = "Muscle", color = MaterialTheme.colors.primary)
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
                Text(text = "Fat", color = MaterialTheme.colors.primary)
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
        }
        }

//--------------------------------------------------------------------------------------------

        Card(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp
        ) {
            Column(horizontalAlignment = CenterHorizontally) {

            Text(text = "Your daily activity:", color = MaterialTheme.colors.primary)
            Row(

                verticalAlignment = Alignment.CenterVertically) {
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
                Text(text = "Active", color = MaterialTheme.colors.primary)
//Spacer(modifier = Modifier.width(8.dp))

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
                Text(text = "Tired", color = MaterialTheme.colors.primary)
            }
            }
        }

        //--------------------------------------------------------------------------------------

        Card(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Rate your fitness level:", color = MaterialTheme.colors.primary)
                Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,

                ) {
                    var selectedLevel by remember { mutableStateOf("") }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(text = "Rookie", color = MaterialTheme.colors.primary)
                        Checkbox(
                            checked = selectedLevel == "new",
                            onCheckedChange = { isChecked ->
                                if (isChecked) {
                                    selectedLevel = "new"
                                    onEvent.invoke(FirstScreenEvent.ChangePhysiqLevel(30L))
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
                        Text(text = "Normal", color = MaterialTheme.colors.primary)
                        Checkbox(
                            checked = selectedLevel == "normal",
                            onCheckedChange = { isChecked ->
                                if (isChecked) {
                                    selectedLevel = "normal"
                                    onEvent.invoke(FirstScreenEvent.ChangePhysiqLevel(45L))
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
                        Text(text = "PRO", color = MaterialTheme.colors.primary)
                        Checkbox(
                            checked = selectedLevel == "pro",
                            onCheckedChange = { isChecked ->
                                if (isChecked) {
                                    selectedLevel = "pro"
                                    onEvent.invoke(FirstScreenEvent.ChangePhysiqLevel(60L))
                                }
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = MaterialTheme.colors.primary,
                                uncheckedColor = MaterialTheme.colors.primaryVariant
                            ),
                            //modifier = Modifier.padding(5.dp)
                        )

                    }
                }
                }
            }

//-------------------------------------------------------------------------------------------------

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
            Text(text = "Complete", color = MaterialTheme.colors.primary)
        }

    }
}
@Composable
fun WeightItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = text,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(if (isSelected) Color.Gray else Color.Transparent)
            .clickable { onClick() }
    )
}
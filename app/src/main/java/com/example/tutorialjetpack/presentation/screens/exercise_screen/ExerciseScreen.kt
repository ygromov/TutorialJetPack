package com.example.tutorialjetpack.presentation.screens.exercise_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ExerciseScreen(
    exerciseState: ExerciseState,
    navController: NavController,
    onEvent: (ExersizeEvent) -> Unit,
) {
    var state by remember { mutableStateOf(0) }
    var appName by remember { mutableStateOf(TextFieldValue()) }
    var userName by remember { mutableStateOf(TextFieldValue()) }
    var height by remember { mutableStateOf(TextFieldValue()) }
    var weight by remember { mutableStateOf(TextFieldValue()) }
    var body by remember { mutableStateOf(TextFieldValue()) }
    var activ by remember { mutableStateOf(TextFieldValue()) }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Black, Color.LightGray, Color.Green
                        )
                    ), alpha = 0.3f
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (state) {
                0 -> EnterAppNameScreen(appName, onNameChange = { appName=it }) {
                    state = 1
                }

                1 -> EnterUserNameScreen(userName, onWeightChange = { userName = it }) {
                    state = 2
                }

                2 -> EnterHeightScreen(height, onWeightChange = { height = it }) {
                    state =3// You can process the collected data here or reset the state for a new cycle
                }

                3 -> EnterWeightScreen(weight, onWeightChange = { weight = it }) {
                    state = 4// You can process the collected data here or reset the state for a new cycle
                }

                4 -> EnterBodyScreen(body, onWeightChange = { body = it }) {
                    state = 5
                }

                5 -> EnterActivScreen(activ, onWeightChange = { activ = it }) {
                    state = 6
                }
            }
        }
    }
}

@Composable
fun EnterAppNameScreen(
    name: TextFieldValue,
    onNameChange: (TextFieldValue) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Придумай мне имя!", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = name,
            onValueChange = onNameChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp).background(Color.White)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick =  onNextClick ,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("Присвоить имя", color = Color.White)
        }
    }
}


@Composable
fun EnterUserNameScreen(
    weight: TextFieldValue,
    onWeightChange: (TextFieldValue) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Мне нравится, а как тебя зовут?", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = weight,
            onValueChange = onWeightChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("Запомнить имя", color = Color.White)
        }
    }
}

@Composable
fun EnterWeightScreen(
    weight: TextFieldValue,
    onWeightChange: (TextFieldValue) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Красивое имя, а сколько ты весишь?", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = weight,
            onValueChange = onWeightChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("Запомнить вес", color = Color.White)
        }
    }
}

@Composable
fun EnterHeightScreen(
    weight: TextFieldValue,
    onWeightChange: (TextFieldValue) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Твоя форма лучше чем у 78% пользователей, а какой у тебя рост?",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = weight,
            onValueChange = onWeightChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("Запомнить рост", color = Color.White)
        }
    }
}

@Composable
fun EnterBodyScreen(
    weight: TextFieldValue,
    onWeightChange: (TextFieldValue) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Отлично, а как ты оценишь свое телосложение?", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = weight,
            onValueChange = onWeightChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("Запомнить", color = Color.White)
        }
    }
}

@Composable
fun EnterActivScreen(
    weight: TextFieldValue,
    onWeightChange: (TextFieldValue) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Великолепно, а теперь оцени свою дневную активность, от 1 до 10!",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = weight,
            onValueChange = onWeightChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {
            Text("Класс, а теперь приступим!", color = Color.White)
        }
    }
}
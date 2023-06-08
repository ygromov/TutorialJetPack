package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.presentation.screens.ProgressBar
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpScreenEvent
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpState
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OfpScreen(state: OfpState, onEvent: (OfpScreenEvent) -> Unit) {
    Scaffold() {
        Column {
            ProgressBar()                   //иконки с тренировочным прогрессом
            OfpMainItem(onEvent)      //переходы на тренировки, журнал, офпТест
            Column() {
                OfpItem(ofp = state.list, onEvent = onEvent) //заполняются textField из списка
                BtnAnalize(onEvent)   //здесь кнопка обработки введенных данных и создание трен программы в training
                timer()                     //таймер
            }
        }
    }
}

@Composable
fun BtnAnalize(
    onEvent: (OfpScreenEvent) -> Unit
//    navController: NavController
) {
    Button(modifier = Modifier.padding(5.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
        onClick = {
            onEvent.invoke(OfpScreenEvent.BtnAnalize)
        }
    ) {
        Text(text = "Analize")
    }
}


/*
class ofpAnalize(){
fun analize(push, pull, squat, abc, extens) {}  //с турником
fun analize(push, squat, abc, extens) {}        //без турника
}
 */
//error commit

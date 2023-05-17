package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.OfpMainItem
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.ProgressBar
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.ofpItem
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.timer
import com.example.tutorialjetpack.utils.Constants.OFPITEM
import com.example.tutorialjetpack.utils.Routers
import java.util.Timer

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OfpScreen(navController: NavController) {
    Scaffold() {
        Column {
            ProgressBar()                   //иконки с тренировочным прогрессом
            OfpMainItem(navController)      //переходы на тренировки, журнал, офпТест
            Column() {
                ofpItem(ofpField = OFPITEM) //заполняются textField из списка
                btnAnalize(navController)   //здесь кнопка обработки введенных данных и создание трен программы в training
                timer()                     //таймер
            }
        }
    }
}

@Composable
fun btnAnalize(navController: NavController) {
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
            navController.navigate(Routers.TRAINING.route)
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
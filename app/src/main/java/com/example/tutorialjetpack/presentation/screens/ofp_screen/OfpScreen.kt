package com.example.tutorialjetpack.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.data.datastore.AppDataStore
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpScreenEvent
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpState
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.OfpItem
import com.example.tutorialjetpack.presentation.screens.ofp_screen.components.Timer


//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OfpScreen(
    state: OfpState,
    onEvent: (OfpScreenEvent) -> Unit,
    dataStore: AppDataStore
) {


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(start = 8.dp, top = 8.dp,end = 8.dp) ) {
            Text(text = "Hello, ${state.name}" )
            Card() {
                Text(text = "Enter in each field how many repetitions you do in one minute. The timer will help you!")
            }
            Column() {
                OfpItem(ofp = state.list, onEvent = onEvent) //заполняются textField из списка
                BtnAnalize(onEvent)   //здесь кнопка обработки введенных данных и создание трен программы в training
                Timer(
                    totalTime = 45L * 1000L,
                    handleColor = Color.Red,
                    inactiveBarColor = Color.DarkGray,
                    activeBarColor = Color.Red,    //(0xFF37B900),
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    }
}

@Composable
fun BtnAnalize(
    onEvent: (OfpScreenEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.Center
    ) {

        Button(modifier = Modifier.padding(5.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),

            onClick = {
                onEvent.invoke(OfpScreenEvent.BtnAnalize)
            }
        ) {
            Text(text = "Analize")
        }
    }
}

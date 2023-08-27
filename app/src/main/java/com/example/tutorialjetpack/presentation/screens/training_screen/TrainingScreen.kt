package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState
import com.example.tutorialjetpack.presentation.screens.training_screen.components.AdviceForExersize
import com.example.tutorialjetpack.presentation.screens.training_screen.components.NormalTrainingField
import com.example.tutorialjetpack.presentation.screens.training_screen.components.ProTrainingField
import com.example.tutorialjetpack.presentation.screens.training_screen.components.RookieTrainingField
import com.example.tutorialjetpack.presentation.screens.training_screen.components.TopBar

private const val TAG = "TrainingScreen"

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@SuppressLint("UnrememberedMutableState")
@Composable
fun TrainingScreen(
    state: TrainingState,
    navController: NavController,
    onEvent: (TrainingEvent) -> Unit
) {         //вот сюда передали

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_gradient),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.4f
        )

        Column {
            TopBar(navController = navController)

            when (state.level) {
                30L -> RookieTrainingField(state = state, onEvent =onEvent , navController =navController)
                45L -> NormalTrainingField(state = state, onEvent = onEvent, navController = navController)
                60L -> ProTrainingField(state = state, onEvent = onEvent, navController = navController)
            }
            AdviceForExersize()
            /*
            
            when(datastore.level) ->
            30 -> RookieTrain
            45  -> NormalTrain
            60 -> ProTrain
            
             */

        }
    }
}

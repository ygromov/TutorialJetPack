package com.example.tutorialjetpack.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tutorialjetpack.data.datastore.AppDataStoreManager
import com.example.tutorialjetpack.presentation.DetailsScreen
import com.example.tutorialjetpack.presentation.JournalScreen
import com.example.tutorialjetpack.presentation.OfpScreen
import com.example.tutorialjetpack.presentation.TrainingScreen
import com.example.tutorialjetpack.presentation.screens.exercise_screen.ExerciseScreen
import com.example.tutorialjetpack.presentation.screens.exercise_screen.ExerciseViewModel
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstScreen
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstViewModel
import com.example.tutorialjetpack.presentation.screens.first_screen.NavigationFirstScreenEvent
import com.example.tutorialjetpack.presentation.screens.ofp_screen.NavigationOfpScreen
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpViewModel
import com.example.tutorialjetpack.utils.Routers


@Composable
fun Navigation(navController: NavHostController,
               startDestination:String
) {
    NavHost(navController = navController,
        startDestination = startDestination
        //startDestination = Routers.FIRST.route
    ) {

        composable(Routers.FIRST.route) {
            val viewModel: FirstViewModel = hiltViewModel()
            LaunchedEffect(true) {
                viewModel.eventFlow.collect {
                    when (it) {
                        is NavigationFirstScreenEvent.OfpScreen -> {
                            navController.navigate(Routers.OFP.route)
                        }
                    }
                }
            }
            FirstScreen(
                imtState = viewModel.state,
                onEvent = viewModel::onEvent,
                appDataStoreManager = AppDataStoreManager(Application())
                //AppDataStoreManager(Application())
            )
        }

        composable(Routers.OFP.route) {
            val viewModel: OfpViewModel = hiltViewModel()

            LaunchedEffect(true) {
                viewModel.eventFlow.collect {
                    when (it) {
                        is NavigationOfpScreen.OfpScreenNavigation -> {
                            navController.navigate(it.route)
                        }
                    }
                }
            }

            OfpScreen(viewModel.state, viewModel::onEvent)
        }
        composable(Routers.JOURNAL.route) {
            JournalScreen(navController = navController)
        }

        composable(Routers.TRAINING.route) {
            TrainingScreen(navController = navController)
        }
        composable(Routers.DETAILS.route) {
            DetailsScreen(navController = navController)
        }
        composable(Routers.EXERCISE.route) {
            val viewModel: ExerciseViewModel = hiltViewModel()
            //ExerciseScreen(state = , navController = )
            ExerciseScreen(
                viewModel.state,
                //viewModel.userOfpData,
                navController = navController)
        }
    }
}
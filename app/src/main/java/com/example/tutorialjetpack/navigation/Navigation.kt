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
import com.example.tutorialjetpack.presentation.RetryOfpScreen
import com.example.tutorialjetpack.presentation.TrainingScreen
import com.example.tutorialjetpack.presentation.screens.details_screen.DetailsViewModel
import com.example.tutorialjetpack.presentation.screens.details_screen.NavigationDetailsScreen
import com.example.tutorialjetpack.presentation.screens.exercise_screen.ExerciseScreen
import com.example.tutorialjetpack.presentation.screens.exercise_screen.ExerciseViewModel
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstScreen
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstViewModel
import com.example.tutorialjetpack.presentation.screens.first_screen.NavigationFirstScreenEvent
import com.example.tutorialjetpack.presentation.screens.intermediate_analize_screen.IntermediateAnalizeScreen
import com.example.tutorialjetpack.presentation.screens.intermediate_first_screen.IntermediateFirstScreen
import com.example.tutorialjetpack.presentation.screens.settings_screen.SettingsViewModel
import com.example.tutorialjetpack.presentation.screens.ofp_screen.NavigationOfpScreen
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpViewModel
import com.example.tutorialjetpack.presentation.screens.retry_ofp.NavigationRetryOfpScreen
import com.example.tutorialjetpack.presentation.screens.retry_ofp.RetryOfpViewModel
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingViewModel
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
                        is NavigationFirstScreenEvent.IntermediateFirstScreen -> {
                            navController.navigate(Routers.INTERMEDIATEFIRST.route)
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

            OfpScreen(viewModel.state, viewModel::onEvent,
                dataStore = AppDataStoreManager(Application()))
        }
        composable(Routers.RETRYOFP.route) {
            val viewModel:RetryOfpViewModel = hiltViewModel()
            LaunchedEffect(true) {
                viewModel.eventFlow.collect {
                    when (it) {
                        is NavigationRetryOfpScreen.RetryOfpScreenNavigation -> {
                            navController.navigate(it.route)
                        }
                    }
                }
            }
            RetryOfpScreen(viewModel.state, viewModel::onEvent)
        }
        composable(Routers.JOURNAL.route) {
            val viewModel:SettingsViewModel = hiltViewModel()
            JournalScreen(navController = navController, viewModel.state)
        }
        composable(Routers.TRAINING.route) {
            val viewModel:TrainingViewModel = hiltViewModel()
            TrainingScreen(viewModel.state, navController = navController, onEvent = viewModel::OnEvent)
        }
        composable(Routers.DETAILS.route) {
            val viewModel: DetailsViewModel = hiltViewModel()
            LaunchedEffect(true) {
                viewModel.eventFlow.collect {
                    when (it) {
                        is NavigationDetailsScreen.DetailsScreenNavigation -> {
                            navController.navigate(it.route)
                        }
                    }
                }
            }
            DetailsScreen(viewModel.state,viewModel::onEvent)
        }
        composable(Routers.EXERCISE.route) {
            val viewModel: ExerciseViewModel = hiltViewModel()
            ExerciseScreen(
                viewModel.state,
                //viewModel.userOfpData,
                navController = navController,
                onEvent = viewModel::onEvent,)
        }
        composable(Routers.INTERMEDIATEFIRST.route){
            IntermediateFirstScreen(navController = navController)
        }
        composable(Routers.INTERMEDIATEANALIZE.route){
            IntermediateAnalizeScreen(navController = navController)
        }
    }
}
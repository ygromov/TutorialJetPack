package com.example.tutorialjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tutorialjetpack.presentation.DetailsScreen
import com.example.tutorialjetpack.presentation.JournalScreen
import com.example.tutorialjetpack.presentation.OfpScreen
import com.example.tutorialjetpack.presentation.TrainingScreen
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstScreen
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstViewModel
import com.example.tutorialjetpack.presentation.screens.first_screen.NavigationFirstScreenEvent
import com.example.tutorialjetpack.presentation.screens.ofp_screen.NavigationOfpScreen
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpViewModel
import com.example.tutorialjetpack.utils.Routers


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routers.FIRST.route) {

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
                onEvent = viewModel::onEvent
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
    }
}
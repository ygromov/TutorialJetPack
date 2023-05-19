package com.example.tutorialjetpack.presentation.screens.ofp_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.utils.Routers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OfpViewModel : ViewModel() {
    var state by mutableStateOf(OfpState())

    private val _eventFlow = MutableSharedFlow<NavigationOfpScreen>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: OfpScreenEvent) {
        when (event) {
            is OfpScreenEvent.ChangeOfpItem -> {
                changeOfpItem(event.value, event.index)
            }
//            is OfpScreenEvent.ChangePush -> {
//                setPush(event.value)

            is OfpScreenEvent.BtnAnalize -> {
                changeNavigation()
            }
            is OfpScreenEvent.BtnTraining -> {
                changeNavigation()
            }
            is OfpScreenEvent.BtnJournal -> {
                changeNavigationToJournal()
            }
            is OfpScreenEvent.BtnDetails -> {
                changeNavigationToDetails()
            }

        }
    }

    private fun changeNavigationToDetails() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.DETAILS.route)
            )
        }
    }

    private fun changeNavigationToJournal() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.JOURNAL.route)
            )
        }
    }

   // private fun changeNavigationToTraining() {
//        viewModelScope.launch {
//            _eventFlow.emit(
//                NavigationOfpScreen.OfpScreenNavigation(Routers.TRAINING.route)
//            )
//        }
    //}

    private fun changeNavigation() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.TRAINING.route)
            )
        }
    }

    //[ ("0","push"), ("0","pull") ]
    // [(10,push) , ]
    private fun changeOfpItem(value: String, index: Int) {
        val element = state.list.get(index) // (0,push)
        state.list.set(index = index, element = element.copy(value = value)) // (10,push)
    }

//    private fun setPush(value: String) {
//        state = state.copy(push = value)
//    }
}

sealed class NavigationOfpScreen {
    data class OfpScreenNavigation(val route: String) : NavigationOfpScreen()
}
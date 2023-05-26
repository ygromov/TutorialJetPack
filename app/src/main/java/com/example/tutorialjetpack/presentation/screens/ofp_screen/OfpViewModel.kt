package com.example.tutorialjetpack.presentation.screens.ofp_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.model.OfpModel
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.utils.Resource
import com.example.tutorialjetpack.utils.Routers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfpViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
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
                changeNavigation()                      //add opfData to DB
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

    private fun changeNavigation() {
        viewModelScope.launch {
            repository.addOfpData(
                ofp = OfpModel(
                    userId = 1,
                    push = 1,
                    pull = 1,
                    squat = 1,
                    abc = 1,
                    extens = 1
                )
            ).collect {
                when (it) {
                    is Resource.Error -> {
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        _eventFlow.emit(
                            NavigationOfpScreen.OfpScreenNavigation(Routers.TRAINING.route)
                        )
                    }
                }
            }

        }
    }

    //[ ("0","push"), ("0","pull") ]
    // [(10,push) , ]
    private fun changeOfpItem(value: String, index: Int) {
        val element = state.list.get(index) // (0,push)
        state.list.set(index = index, element = element.copy(value = value)) // (10,push)
    }
}

sealed class NavigationOfpScreen {
    data class OfpScreenNavigation(val route: String) : NavigationOfpScreen()
}
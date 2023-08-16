package com.example.tutorialjetpack.presentation.screens.ofp_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.data.datastore.AppDataStore
import com.example.tutorialjetpack.domain.model.OfpModel
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.utils.Resource
import com.example.tutorialjetpack.utils.Routers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "OfpViewModel"

@HiltViewModel
class OfpViewModel @Inject constructor(
    private val repository: Repository,
    private val dataStore: AppDataStore
) : ViewModel() {
    var state by mutableStateOf(OfpState())

    private val _eventFlow = MutableSharedFlow<NavigationOfpScreen>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            val id = repository.getId()
            state = state.copy(userId = id!!.toInt())
        }
        viewModelScope.launch {
            val name = repository.getUserData().collect {
                it.data?.let {
                    state = state.copy(name = it.name)
                }
            }
        }
        viewModelScope.launch {
            val value = dataStore.readValue("UserPhysLevel") ?: 35L
            state = state.copy(userPhysLevel = value)
            Log.d(TAG, "viewModelOfp: $value")
        }
    }

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
                toTrainingScreen()
            }

            is OfpScreenEvent.BtnJournal -> {
                changeNavigationToJournal()
            }

            is OfpScreenEvent.BtnDetails -> {
                changeNavigationToDetails()
            }

            is OfpScreenEvent.ChangePush -> {
                changePush(event.value)
            }

            is OfpScreenEvent.ChangePull -> {
                changePull(event.value)
            }

            is OfpScreenEvent.ChangeSquat -> {
                changeSquat(event.value)
            }

            is OfpScreenEvent.ChangeAbs -> {
                changeAbs(event.value)
            }

            is OfpScreenEvent.ChangeExtens -> {
                changeExtens(event.value)
            }

        }
    }

    private fun changeExtens(value: Int) {
        state = state.copy(extens = value)
    }

    private fun changeAbs(value: Int) {
        state = state.copy(abs = value)
    }

    private fun changeSquat(value: Int) {
        state = state.copy(squat = value)
    }

    private fun changePull(value: Int) {
        state = state.copy(pull = value)
    }

    private fun changePush(value: Int) {
        state = state.copy(push = value)
    }

    private fun toTrainingScreen() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.TRAINING.route)
            )
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
                    userId = state.userId, //TODO get id from shared pref
                    push = state.list[0].value.toInt(),
                    pull = state.list[1].value.toInt(),
                    squat = state.list[2].value.toInt(),
                    abc = state.list[3].value.toInt(),
                    extens = state.list[4].value.toInt()
                )
            ).collect {
                when (it) {
                    is Resource.Error -> {
                    }

                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        _eventFlow.emit(
                            NavigationOfpScreen.OfpScreenNavigation(Routers.INTERMEDIATEANALIZE.route)
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
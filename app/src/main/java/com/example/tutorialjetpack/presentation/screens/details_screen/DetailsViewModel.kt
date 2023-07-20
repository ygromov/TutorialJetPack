package com.example.tutorialjetpack.presentation.screens.details_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.analize.Analyze
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.utils.Routers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DetailsViewModel"

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: Repository,
    private val analize: Analyze
) : ViewModel() {
    private val _eventFlow = MutableSharedFlow<NavigationDetailsScreen>()
    val eventFlow = _eventFlow.asSharedFlow()

    var state by mutableStateOf(DetailsState())

    init {
        getOfp()
        getUserInfo()
        getOfpGoal()
    }

    fun onEvent(event: DetailsScreenEvent) {
        when (event) {
            is DetailsScreenEvent.GetUserInfo -> {
                getUserInfo()
            }

            is DetailsScreenEvent.GetOfp -> {
                getOfp()
            }

            is DetailsScreenEvent.ToOfpScreen -> {
                toOfpScreen()
            }

            is DetailsScreenEvent.ToTrainingScreen -> {
                toTrainingScreen()
            }

            is DetailsScreenEvent.ToJournalScreen -> {
                toJournalScreen()
            }
        }
    }

    private fun getOfpGoal() {
        viewModelScope.launch {
            analize.analizeOfpToGoal().map {
                state = state.copy(
                    pushGoal = it.push,
                    pullGoal = it.pull,
                    squatGoal = it.squat,
                    absGoal = it.abs,
                    extensGoal = it.extens
                )
            }
        }
    }

    private fun toJournalScreen() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationDetailsScreen.DetailsScreenNavigation(Routers.JOURNAL.route)
            )
        }
    }

    private fun toTrainingScreen() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationDetailsScreen.DetailsScreenNavigation(Routers.TRAINING.route)
            )
        }
    }

    private fun toOfpScreen() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationDetailsScreen.DetailsScreenNavigation(Routers.OFP.route)
            )
        }
    }

    private fun getOfp() {
        viewModelScope.launch {
            repository.getUserOfp().collect { resource ->
                //Log.d(TAG, "getUserOfpData2: ${resource.data?.push}")
                resource.data?.let { ofpModel ->
                    state = state.copy(
                        push = ofpModel.push,
                        pull = ofpModel.pull,
                        squat = ofpModel.squat,
                        abs = ofpModel.abc,
                        extens = ofpModel.extens
                    )
                }
            }
        }
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            repository.getUserData().collect { resource ->
                resource.data?.let { userModel ->
                    state = state.copy(
                        name = userModel.name,
                        age = userModel.age,
                        weight = userModel.weight,
                        height = userModel.height,
                        gender = userModel.gender,

                        )
                }
            }
        }
    }
}

sealed class NavigationDetailsScreen {
    data class DetailsScreenNavigation(val route: String) : NavigationDetailsScreen()
}
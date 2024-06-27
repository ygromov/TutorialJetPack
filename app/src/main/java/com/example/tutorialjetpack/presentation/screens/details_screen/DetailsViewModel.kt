package com.example.tutorialjetpack.presentation.screens.details_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.data.datastore.AppDataStore
import com.example.tutorialjetpack.domain.analize.Analyze
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.presentation.screens.first_screen.FirstScreenEvent
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
    private val analize: Analyze,
    private val datastore: AppDataStore
) : ViewModel() {
    private val _eventFlow = MutableSharedFlow<NavigationDetailsScreen>()
    val eventFlow = _eventFlow.asSharedFlow()

    var state by mutableStateOf(DetailsState())

    init {
        getOfp()
        getUserInfo()
        getOfpGoal()
        viewModelScope.launch {
           state = state.copy(countTraining = datastore.readValue("countTraining") ?: 0)
            state = state.copy(pushMax = datastore.readValue("pushMax") ?: 0)
            state = state.copy(pullMax = datastore.readValue("pullMax") ?: 0)
            state = state.copy(squatMax = datastore.readValue("squatMax") ?: 0)
            state = state.copy(absMax = datastore.readValue("abcMax") ?: 0)
            state = state.copy(extensMax = datastore.readValue("extensMax") ?: 0)
            state = state.copy(maxPush = maxPush())
        }

        Log.d(TAG, "test: ${state.pushMax}")
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
            is DetailsScreenEvent.ToFirstScreen -> {
                toFirstScreen()
            }
        }
    }

    suspend fun maxPush(): Int{
        val test = analize.sumOneTrainPush(state.pushMax.toInt())
        return test
    }

    private fun getOfpGoal() {
        viewModelScope.launch {
            analize.analizeOfpToGoal().map {
                state = state.copy(
                    pushMax = it.push.toLong(),
                    pullMax = it.pull.toLong(),
                    squatMax = it.squat.toLong(),
                    absMax = it.abs.toLong(),
                    extensMax = it.extens.toLong()
                )
            }
        }
    }

    private fun toFirstScreen() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationDetailsScreen.DetailsScreenNavigation(Routers.OFP.route)
            )
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
                NavigationDetailsScreen.DetailsScreenNavigation(Routers.RETRYOFP.route)
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
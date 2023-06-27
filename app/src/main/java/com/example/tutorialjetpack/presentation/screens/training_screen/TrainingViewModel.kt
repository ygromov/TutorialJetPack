package com.example.tutorialjetpack.presentation.screens.training_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.data.analize.Analyze
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TrainingViewModel"

@HiltViewModel
class TrainingViewModel @Inject constructor(
    private val repository: Repository,
    private val analize: Analyze
) : ViewModel() {
    var state by mutableStateOf(TrainingState())

    init {
        getUserOfpData()
        Log.d(TAG, "getUserOfpData1: ${getUserOfpData()}") // ме
    }

    fun OnEvent(event: TrainingEvent) {
        when (event) {
            is TrainingEvent.CompleteSet -> {
                getTrainPrograms()
                Log.d(TAG, "OnEvent: ${getTrainPrograms()}")
            }
        }
    }

    private fun getTrainPrograms() {            //делает первый подход в тренировочной программе
        viewModelScope.launch {
            analize.createTrain().map {
                Log.d(TAG, "getTrainPrograms: ${it}")
                //для полной тренировочной программы, нужно расширить state
                state = state.copy(
                    push = it.pushUpReps,
                    pull =  it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extens
                )
            }
        }
    }

    private fun getUserOfpData() {
        viewModelScope.launch {
            repository.getUserOfp().collect { resource ->
                Log.d(TAG, "getUserOfpData2: ${resource.data?.push}")
                resource.data?.let { ofpModel ->
                    state = state.copy(
                        push = ofpModel.push,
                        pull = ofpModel.pull,
                        squat = ofpModel.squat,
                        abc = ofpModel.abc,
                        extens = ofpModel.extens
                    )
                }
            }
        }
    }
}
package com.example.tutorialjetpack.presentation.screens.training_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TrainingViewModel"

@HiltViewModel
class TrainingViewModel @Inject constructor(
    private val repository: Repository
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
            }
        }
    }

    private fun getTrainPrograms() {            //тестовый вариант
        state = state.copy(
            push = state.push - 2,
            pull = state.pull - 2,
            squat = state.squat - 2,
            abc = state.abc - 2,
            extens = state.extens - 2,
            headText = "2 set"
        )
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
//error commit
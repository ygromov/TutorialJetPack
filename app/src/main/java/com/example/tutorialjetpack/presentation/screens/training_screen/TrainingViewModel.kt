package com.example.tutorialjetpack.presentation.screens.training_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.analize.Analyze
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
        getTrainPrograms()
        //getUserOfpData()
        //Log.d(TAG, "getUserOfpData1: ${getUserOfpData()}") // ме
    }

    fun OnEvent(event: TrainingEvent) {
        when (event) {
            is TrainingEvent.OneSet -> {
                getTrainPrograms()
            }

            is TrainingEvent.TwoSet -> {
                getTwoSetTrainPrograms()
            }

            is TrainingEvent.ThreeSet -> {
                getThreeSetTrainPrograms()
            }

            is TrainingEvent.FourSet -> {
                getFourSetTrainPrograms()
            }
        }
    }

    private fun getTrainPrograms() {            //делает первый подход в тренировочной программе
        viewModelScope.launch {
            analize.createTrain().map {
                //Log.d(TAG, "getTrainPrograms: ${it}")
                //для полной тренировочной программы, нужно расширить state
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
                    pushUpSets = it.pushUpSets,
                    pullUpSets = it.pullUpSets,
                    squatSets = it.squatSets,
                    sitUpSets = it.sitUpSets,
                    extensSets = it.extensSets,
                    headText = "1 set: rest 1 minute"
                )
            }
        }
    }

    private fun getTwoSetTrainPrograms() {            //делает второй подход в тренировочной программе
        viewModelScope.launch {
            analize.createTwoSetTrain().map {
                //Log.d(TAG, "getTrainPrograms: ${it}")
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
                    pushUpSets = it.pushUpSets,
                    pullUpSets = it.pullUpSets,
                    squatSets = it.squatSets,
                    sitUpSets = it.sitUpSets,
                    extensSets = it.extensSets,
                    headText = "2 set: rest 1,5 minute"
                )
            }
        }
    }

    private fun getThreeSetTrainPrograms() {            //делает третий подход в тренировочной программе
        viewModelScope.launch {
            analize.createThreeSetTrain().map {
                //Log.d(TAG, "getTrainPrograms: ${it}")
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
                    pushUpSets = it.pushUpSets,
                    pullUpSets = it.pullUpSets,
                    squatSets = it.squatSets,
                    sitUpSets = it.sitUpSets,
                    extensSets = it.extensSets,
                    headText = "3 set: rest 1,5 minute"
                )
            }
        }
    }

    private fun getFourSetTrainPrograms() {            //делает четвертый подход в тренировочной программе
        viewModelScope.launch {
            analize.createFourSetTrain().map {
                //Log.d(TAG, "getTrainPrograms: ${it}")
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
                    pushUpSets = it.pushUpSets,
                    pullUpSets = it.pullUpSets,
                    squatSets = it.squatSets,
                    sitUpSets = it.sitUpSets,
                    extensSets = it.extensSets,
                    headText = "4 set: rest 1,5 minute"
                )
            }
        }
    }

    private fun getUserOfpData() {                      //чистые данные с офптеста из БД
        viewModelScope.launch {
            repository.getUserOfp().collect { resource ->
                //Log.d(TAG, "getUserOfpData2: ${resource.data?.push}")
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
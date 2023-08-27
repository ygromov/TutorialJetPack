package com.example.tutorialjetpack.presentation.screens.training_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.data.datastore.AppDataStore
import com.example.tutorialjetpack.domain.analize.Analyze
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TrainingViewModel"

@HiltViewModel
class TrainingViewModel @Inject constructor(
    private val repository: Repository,
    private val analize: Analyze,
    private val dataStore: AppDataStore
) : ViewModel() {
    var state by mutableStateOf(TrainingState())
    var count = mutableStateOf(0)

    init {
        getTrainPrograms()
        viewModelScope.launch {                                     //do not use
            val name = repository.getUserData().collect {
                it.data?.let {
                    state = state.copy(name = it.name)
                }

            }

        }
        viewModelScope.launch {
            val cos = dataStore.readValue("countTraining")
            count.value = cos?.toInt() ?: 0
            Log.d(TAG, "trainingCount: $cos")
        }
        viewModelScope.launch {
            val level = dataStore.readValue("UserPhysLevel") ?: 0
            state = state.copy(level = level)
        }

        //Log.d(TAG, "count: $count")
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

            is TrainingEvent.TrainingCount -> {
                trainingCount()
            }
        }
    }

    private fun trainingCount() {
        count.value++
        viewModelScope.launch {
            dataStore.setValue(key = "countTraining", value = count.value.toLong())

        }

    }

    private fun getTrainPrograms() {            //делает первый подход в тренировочной программе
        viewModelScope.launch {
            analize.createTrain().map {
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
                    headText = "1 set",
                    flag = 2
                )
            }
            val pull: Long = dataStore.readValue("pullMax") ?: 0
            dataStore.setValue("pullMax", pull + state.pull.toLong())

            val push = dataStore.readValue("pushMax") ?: 0
            dataStore.setValue("pushMax", push + state.push.toLong())

            val squat = dataStore.readValue("squatMax") ?: 0
            dataStore.setValue("squatMax", squat + state.squat.toLong())

            val abc = dataStore.readValue("abcMax") ?: 0
            dataStore.setValue("abcMax", abc + state.abc.toLong())

            val extens = dataStore.readValue("extensMax") ?: 0
            dataStore.setValue("extensMax", extens + state.extens.toLong())
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
                    headText = "2 set",
                    flag = 3
                )
            }
            val pull: Long = dataStore.readValue("pullMax") ?: 0
            dataStore.setValue("pullMax", pull + state.pull.toLong())

            val push = dataStore.readValue("pushMax") ?: 0
            dataStore.setValue("pushMax", push + state.push.toLong())

            val squat = dataStore.readValue("squatMax") ?: 0
            dataStore.setValue("squatMax", squat + state.squat.toLong())

            val abc = dataStore.readValue("abcMax") ?: 0
            dataStore.setValue("abcMax", abc + state.abc.toLong())

            val extens = dataStore.readValue("extensMax") ?: 0
            dataStore.setValue("extensMax", extens + state.extens.toLong())
        }
    }

    private fun getThreeSetTrainPrograms() {            //делает третий подход в тренировочной программе
        viewModelScope.launch {
            analize.createThreeSetTrain().map {
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
                    headText = "3 set",
                    flag = 4
                )
            }
            val pull: Long = dataStore.readValue("pullMax") ?: 0
            dataStore.setValue("pullMax", pull + state.pull.toLong())

            val push = dataStore.readValue("pushMax") ?: 0
            dataStore.setValue("pushMax", push + state.push.toLong())

            val squat = dataStore.readValue("squatMax") ?: 0
            dataStore.setValue("squatMax", squat + state.squat.toLong())

            val abc = dataStore.readValue("abcMax") ?: 0
            dataStore.setValue("abcMax", abc + state.abc.toLong())

            val extens = dataStore.readValue("extensMax") ?: 0
            dataStore.setValue("extensMax", extens + state.extens.toLong())
        }
    }

    private fun getFourSetTrainPrograms() {            //делает четвертый подход в тренировочной программе
        viewModelScope.launch {
            analize.createFourSetTrain().map {
                state = state.copy(
                    push = it.pushUpReps,
                    pull = it.pullUpReps,
                    squat = it.squatReps,
                    abc = it.sitUpReps,
                    extens = it.extensReps,
//                    pushUpSets = it.pushUpSets,
//                    pullUpSets = it.pullUpSets,
//                    squatSets = it.squatSets,
//                    sitUpSets = it.sitUpSets,
//                    extensSets = it.extensSets,
                    headText = "4 set",
                    flag = 1
                )
            }
            val pull: Long = dataStore.readValue("pullMax") ?: 0
            dataStore.setValue("pullMax", pull + state.pull.toLong())

            val push = dataStore.readValue("pushMax") ?: 0
            dataStore.setValue("pushMax", push + state.push.toLong())

            val squat = dataStore.readValue("squatMax") ?: 0
            dataStore.setValue("squatMax", squat + state.squat.toLong())

            val abc = dataStore.readValue("abcMax") ?: 0
            dataStore.setValue("abcMax", abc + state.abc.toLong())

            val extens = dataStore.readValue("extensMax") ?: 0
            dataStore.setValue("extensMax", extens + state.extens.toLong())
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
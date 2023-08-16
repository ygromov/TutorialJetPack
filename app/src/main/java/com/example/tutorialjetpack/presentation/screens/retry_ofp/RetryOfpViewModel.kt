package com.example.tutorialjetpack.presentation.screens.retry_ofp

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

private const val TAG = "RetryOfpViewModel"

@HiltViewModel
class RetryOfpViewModel @Inject constructor(
    private val repository: Repository,
    private val dataStore: AppDataStore
) : ViewModel() {
    var state by mutableStateOf(RetryOfpState())


    private val _eventFlow = MutableSharedFlow<NavigationRetryOfpScreen>()
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
            val value = dataStore.readValue("UserPhysLevel") ?: 30L
            state = state.copy(userPhysiqLevel = value)
            Log.d(TAG, "userLevel: $value")
        }
    }

    fun onEvent(event: RetryOfpEvent) {
        when (event) {
            is RetryOfpEvent.ChangeOfpItem -> {
                changeOfpItem(event.value, event.index)
            }

            is RetryOfpEvent.BtnAnalize -> {
                changeNavigation()                      //add opfData to DB
            }

            is RetryOfpEvent.BtnTraining -> {
                toTrainingScreen()
            }

            is RetryOfpEvent.BtnJournal -> {
                changeNavigationToJournal()
            }

            is RetryOfpEvent.BtnDetails -> {
                changeNavigationToDetails()
            }

            is RetryOfpEvent.ChangePush -> {
                changePush(event.value)
            }

            is RetryOfpEvent.ChangePull -> {
                changePull(event.value)
            }

            is RetryOfpEvent.ChangeSquat -> {
                changeSquat(event.value)
            }

            is RetryOfpEvent.ChangeAbs -> {
                changeAbs(event.value)
            }

            is RetryOfpEvent.ChangeExtens -> {
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
                NavigationRetryOfpScreen.RetryOfpScreenNavigation(Routers.TRAINING.route)
            )
        }
    }

    private fun changeNavigationToDetails() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationRetryOfpScreen.RetryOfpScreenNavigation(Routers.DETAILS.route)
            )
        }
    }

    private fun changeNavigationToJournal() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationRetryOfpScreen.RetryOfpScreenNavigation(Routers.JOURNAL.route)
            )
        }
    }

    fun isValid(): Boolean {
        return state.name.isNotBlank() && state.push >= 0 && state.pull >= 0 && state.squat >= 0 && state.abs >= 0 && state.extens >= 0
    }

    private fun changeNavigation() {
        if (isValid()) {
            viewModelScope.launch {
                repository.addOfpData(
                    ofp = OfpModel(
                        userId = state.userId,
                        push = state.push,
                        pull = state.pull,
                        squat = state.squat,
                        abc = state.abs,
                        extens = state.extens
                    )
                ).collect {
                    when (it) {
                        is Resource.Error -> {
                        }

                        is Resource.Loading -> {}
                        is Resource.Success -> {
                            _eventFlow.emit(
                                NavigationRetryOfpScreen.RetryOfpScreenNavigation(Routers.INTERMEDIATEANALIZE.route)
                            )
                            dataStore.setValue("countTraining", 0)
                        }
                    }
                }
            }

        } else {

        }


//        viewModelScope.launch {
//            val isDataValid = state.list.all { it.value.isNotBlank() }
//            if (isDataValid) {
//                repository.addOfpData(
//                    ofp = OfpModel(
//                        userId = state.userId,
//                        push = state.list[0].value.toInt(),
//                        pull = state.list[1].value.toInt(),
//                        squat = state.list[2].value.toInt(),
//                        abc = state.list[3].value.toInt(),
//                        extens = state.list[4].value.toInt()
//                    )
//                ).collect {
//                    when (it) {
//                        is Resource.Error -> {
//                        }
//
//                        is Resource.Loading -> {}
//                        is Resource.Success -> {
//                            _eventFlow.emit(
//                                NavigationRetryOfpScreen.RetryOfpScreenNavigation(Routers.INTERMEDIATEANALIZE.route)
//                            )
//                            dataStore.setValue("countTraining", 0)
//                        }
//                    }
//                }
//            } else {
//                //супер ход конем!!!!
//                //блять, что я имел в виду?
//                //понял, если что то пусто, то перехода не будет
//            }
//        }
    }

    //[ ("0","push"), ("0","pull") ]
    // [(10,push) , ]
    private fun changeOfpItem(value: String, index: Int) {
        val element = state.list.get(index) // (0,push)
        state.list.set(index = index, element = element.copy(value = value)) // (10,push)
    }
}

sealed class NavigationRetryOfpScreen {
    data class RetryOfpScreenNavigation(val route: String) : NavigationRetryOfpScreen()
}
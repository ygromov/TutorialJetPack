package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.model.UserModel
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    var state by mutableStateOf(ImtState())

    private val _eventFlow = MutableSharedFlow<NavigationFirstScreenEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: FirstScreenEvent) {
        when (event) {
            is FirstScreenEvent.ChangeGender -> {
                setGender(event.value)
            }
            is FirstScreenEvent.ChangeAge -> {
                setAge(event.value)
            }
            is FirstScreenEvent.ChangeHeight -> {
                setHeight(event.value)
            }
            is FirstScreenEvent.ChangeWeight -> {
                setWeight(event.value)
            }
            is FirstScreenEvent.Complete -> {
                onComplete()
            }
            is FirstScreenEvent.ChangeName -> {
                setName(event.value)
            }
        }

    }



    private fun onComplete() {
        viewModelScope.launch {
            repository.addUserData(
                user = UserModel(
                    name = state.name,
                    age = state.age.toInt(),
                    height = state.height.toInt(),
                    weight = state.weight.toInt(),
                    gender = state.gender
                )
            ).collect{
                when(it){
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        _eventFlow.emit(NavigationFirstScreenEvent.OfpScreen)
                    }
                }
            }


        }
    }
    private fun setName(value: String) {
        state = state.copy(name = value)
    }

    private fun setWeight(value: String) {
        state = state.copy(weight = value)
    }

    private fun setHeight(value: String) {
        state = state.copy(height = value)
    }

    private fun setAge(value: String) {
        state = state.copy(age = value)
    }

    private fun setGender(value: String) {
        state = state.copy(gender = value)
    }


}

sealed class NavigationFirstScreenEvent {
    object OfpScreen : NavigationFirstScreenEvent()
}

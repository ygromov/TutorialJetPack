package com.example.tutorialjetpack.presentation.screens.first_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.data.datastore.AppDataStore
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
    private val repository: Repository,
    private val dataStore: AppDataStore
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
            is FirstScreenEvent.ChangeBody -> {
                setBody(event.value)
            }
            is FirstScreenEvent.ChangeActiv ->{
                setActiv(event.value)
            }
            is FirstScreenEvent.ChangePhysiqLevel -> {
                setPhysAct(event.value)
            }
        }
    }

    private fun setPhysAct(value: Long) {
        viewModelScope.launch {
            dataStore.setValue("UserPhysActiv", value)
        }
    }

    private fun setActiv(value: String) {
        state = state.copy(activ = value)
    }

    private fun setBody(value: String) {
        state = state.copy(body = value)
    }

    private fun onComplete() {
        viewModelScope.launch {
            val name = state.name.trim()
            val age = state.age.trim()
            val height = state.height.trim()
            val weight = state.weight.trim()

            if (name.isEmpty() || age.isEmpty() || height.isEmpty() || weight.isEmpty()) {
                // Обработка ошибки: "Есть пустые поля, заполните все данные"
            } else {
                try {
                    val ageInt = age.toInt()
                    val heightDouble = height.toDouble()
                    val weightDouble = weight.toDouble()

                    if (ageInt <= 0 || heightDouble <= 0.0 || weightDouble <= 0.0) {
                        // Обработка ошибки: "Возраст, рост и вес должны быть положительными числами"
                    } else {
                }
            repository.addUserData(
                user = UserModel(
                    name = state.name,
                    age = state.age.toInt(),
                    height = state.height.toDouble(),
                    weight = state.weight.toDouble(),
                    gender = state.gender
                )
            ).collect{
                when(it){
                    is Resource.Error -> {
                        //"если данные пустые, обработать ошибку" +
                                  //  "если отрицательные или строковые")
                    }
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        _eventFlow.emit(NavigationFirstScreenEvent.IntermediateFirstScreen )
                    }
                }
            }
          } catch (e: NumberFormatException) {
            // Обработка ошибки: "Возраст, рост и вес должны быть числами"
        }
        }
    }}
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
    object IntermediateFirstScreen : NavigationFirstScreenEvent()
}
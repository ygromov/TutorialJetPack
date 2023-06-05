package com.example.tutorialjetpack.presentation.screens.exercise_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(ExerciseState())

    init {
        getUserOfpData()
    }

    fun getUserOfpData() {
        viewModelScope.launch {
            repository.getUserOfp().collect {
                state.list.get(0).value = it.data?.push ?: -1
            }
        }
    }
}
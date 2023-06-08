package com.example.tutorialjetpack.presentation.screens.exercise_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialjetpack.domain.model.OfpFieldModel
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.utils.Resource
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
                    //resource ->
//                when (resource) {
//                    is Resource.Success -> {
//                        val ofpModel = resource.data                                        //записали данные из бд в переменную
//                        val updatedList = state.list.map { fieldModel ->            //замапили данные в List переменную
//                            when (fieldModel.nameExerscise) {
//                                "pushUp" -> ofpModel.let { fieldModel.copy(value = it.push) }
//                                "pullUp" -> ofpModel.let { fieldModel.copy(value = it.pull) }
//                                "squat" -> ofpModel.let { fieldModel.copy(value = it.squat) }
//                                "abc" -> ofpModel.let { fieldModel.copy(value = it.abc) }
//                                "extens" -> ofpModel.let { fieldModel.copy(value = it.extens) }
//                                else -> fieldModel
//                            }
//                        }
//                        state = mutableStateListOf(*updatedList.toTypedArray()).let { state.copy(list = it) }
//                    }
//                    is Resource.Error -> {
//                        // Обработка ошибки, если необходимо
//                    }
//                    is Resource.Loading -> {
                        // Обработка состояния загрузки, если необходимо
//                    }
//                }
            }
        }
    }
}
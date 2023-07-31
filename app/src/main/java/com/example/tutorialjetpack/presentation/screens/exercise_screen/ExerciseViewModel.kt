package com.example.tutorialjetpack.presentation.screens.exercise_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tutorialjetpack.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(ExerciseState())

    init {
        //getUserOfpData()
    }

    fun onEvent(event: ExersizeEvent) {
    when(event){
        is ExersizeEvent.appName ->{
            setAppName(event.value)
        }
        is ExersizeEvent.userName ->{
            setUserName(event.value)
        }
        is ExersizeEvent.gender ->{
            setGender(event.value)
        }
        is ExersizeEvent.age ->{
            setAge(event.value)
        }
        is ExersizeEvent.height ->{
            setHeight(event.value)
        }
        is ExersizeEvent.weight ->{
            setWeight(event.value)
        }
        is ExersizeEvent.body ->{
            setBody(event.value)
        }
        is ExersizeEvent.activ ->{
            setActiv(event.value)
        }
    }
    }

    private fun setActiv(value: String) {
        state = state.copy(activ = value)
    }

    private fun setBody(value: String) {
        state = state.copy(body =  value)
    }

    private fun setWeight(value: String) {
        state = state.copy(weight =  value)
    }

    private fun setHeight(value: String) {
        state = state.copy(height =  value)
    }

    private fun setAge(value: String) {
        state = state.copy(age = value)
    }

    private fun setGender(value: String) {
        state = state.copy(gender =  value)
    }

    private fun setUserName(value: String) {
        state = state.copy(userName =  value)
    }

    private fun setAppName(value: String) {
        state = state.copy(appName = value)
    }
}
//    fun getUserOfpData() {
//        viewModelScope.launch {
//            repository.getUserOfp().collect {
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
//            }
//        }
//    }
//}
//error commit
package com.example.tutorialjetpack.presentation.screens.ofp_screen

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

private const val TAG = "OfpViewModel"

/*
!!!данные в Room попадают нулевыми значениями!!!
 */
@HiltViewModel
class OfpViewModel @Inject constructor(
    private val repository: Repository, // Репозиторий для работы с данными
    private val dataStore: AppDataStore // DataStore для хранения данных
) : ViewModel() {
    // Состояние ViewModel
    var state by mutableStateOf(OfpState())

    // SharedFlow для навигации
    private val _eventFlow = MutableSharedFlow<NavigationOfpScreen>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        // Получаем ID пользователя из репозитория и обновляем состояние
        viewModelScope.launch {
            val id = repository.getId()
            state = state.copy(userId = id!!.toInt())
        }
        // Получаем имя пользователя из репозитория и обновляем состояние
        viewModelScope.launch {
            val name = repository.getUserData().collect {
                it.data?.let {
                    state = state.copy(name = it.name)
                }
            }
        }
        // Получаем уровень физической подготовки пользователя из DataStore и обновляем состояние
        viewModelScope.launch {
            val value = dataStore.readValue("UserPhysLevel") ?: 30L
            state = state.copy(userPhysLevel = value)
            Log.d(TAG, "viewModelOfp: $value")
        }
    }

    // Обработка событий экрана OfpScreen
    fun onEvent(event: OfpScreenEvent) {
        when (event) {
            // Изменение значения в списке упражнений
            is OfpScreenEvent.ChangeOfpItem -> {
                changeOfpItem(event.value, event.index)
            }

            // Нажатие на кнопку "Analize"
            is OfpScreenEvent.BtnAnalize -> {
                changeNavigation()                      //add opfData to DB
            }

            // Нажатие на кнопку "Тренировка"
            is OfpScreenEvent.BtnTraining -> {
                toTrainingScreen()
            }
            // Нажатие на кнопку "Журнал"
            is OfpScreenEvent.BtnJournal -> {
                changeNavigationToJournal()
            }
            // Нажатие на кнопку "Подробнее"
            is OfpScreenEvent.BtnDetails -> {
                changeNavigationToDetails()
            }
            // Изменение количества отжиманий
            is OfpScreenEvent.ChangePush -> {
                changePush(event.value)
            }
            // Изменение количества подтягиваний
            is OfpScreenEvent.ChangePull -> {
                changePull(event.value)
            }
            // Изменение количества приседаний
            is OfpScreenEvent.ChangeSquat -> {
                changeSquat(event.value)
            }
            // Изменение количества повторений на пресс
            is OfpScreenEvent.ChangeAbs -> {
                changeAbs(event.value)
            }
            // Изменение количества гиперэкстензий
            is OfpScreenEvent.ChangeExtens -> {
                changeExtens(event.value)
            }

        }
    }

    // Функции для изменения значений упражнений в состоянии
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

    // Функции для навигации
    private fun toTrainingScreen() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.TRAINING.route)
            )
        }
    }

    private fun changeNavigationToDetails() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.DETAILS.route)
            )
        }
    }

    private fun changeNavigationToJournal() {
        viewModelScope.launch {
            _eventFlow.emit(
                NavigationOfpScreen.OfpScreenNavigation(Routers.JOURNAL.route)
            )
        }
    }

    fun isValid(): Boolean {
        return state.name.isNotBlank() && state.push >= 0 && state.pull >= 0 && state.squat >= 0 && state.abs >= 0 && state.extens >= 0
    }

    // Функция для добавления данных ОФП в БД и перехода на экран анализа
    private fun changeNavigation() {
        if (isValid()){
        viewModelScope.launch {
            // Логируем значения перед отправкой в репозиторий
            Log.d(
                "OfpViewModel",
                "Записываем в БД: push = ${state.push}, pull = ${state.pull}, ..."
            )

            repository.addOfpData(
                ofp = OfpModel(
                    userId = state.userId, //TODO get id from shared pref
                    push = state.list[0].value.toInt(),
                    pull = state.list[1].value.toInt(),
                    squat = state.list[2].value.toInt(),
                    abc = state.list[3].value.toInt(),
                    extens = state.list[4].value.toInt()
                )
            ).collect {
                when (it) {
                    is Resource.Error -> {
                        // Обработка ошибки
                    }

                    is Resource.Loading -> {
                        // Показ индикатора загрузки
                    }

                    is Resource.Success -> {
                        // Переход на экран промежуточного анализа
                        _eventFlow.emit(
                            NavigationOfpScreen.OfpScreenNavigation(Routers.INTERMEDIATEANALIZE.route)
                        )
                    }
                }
            }

        }
    } else{

        }
    }

    //[ ("0","push"), ("0","pull") ]
    // [(10,push) , ]

    // Функция для изменения значения упражнения в списке
    private fun changeOfpItem(value: String, index: Int) {
        val element = state.list.get(index) // (0,push)
        state.list.set(index = index, element = element.copy(value = value)) // (10,push)
    }
}

// Запечатанный класс для описания событий навигации
sealed class NavigationOfpScreen {
    data class OfpScreenNavigation(val route: String) : NavigationOfpScreen()
}
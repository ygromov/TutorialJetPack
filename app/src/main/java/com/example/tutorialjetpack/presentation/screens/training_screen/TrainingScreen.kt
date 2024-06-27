package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState
import com.example.tutorialjetpack.presentation.screens.training_screen.components.AdviceForExersize
import com.example.tutorialjetpack.presentation.screens.training_screen.components.NormalTrainingField
import com.example.tutorialjetpack.presentation.screens.training_screen.components.ProTrainingField
import com.example.tutorialjetpack.presentation.screens.training_screen.components.RookieTrainingField
import com.example.tutorialjetpack.presentation.screens.training_screen.components.TestNormal
import com.example.tutorialjetpack.presentation.screens.training_screen.components.TopBar
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

private const val TAG = "TrainingScreen"

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun TrainingScreen(
    state: TrainingState,
    navController: NavController,
    onEvent: (TrainingEvent) -> Unit
) {
/*
добавить в создание пэйджера:
- количество подходов зависит от уровня юзера(новичок, обычный, про)
перенести вызов advice  в testNormal и привязать совету относительно упражнения
добавить уже нормальные гиф
добавить тесты
 */
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        TrackEvent(eventName = "open_training_screen")            // Отслеживание события открытия экрана

        Column {
            TopBar(navController = navController)                           // Верхняя панель приложения

            val dat = listOf(
                state.level
            )

            val data = listOf(
                "1 set",
                "2 set",
                "3 set",
                "4 set"
            ) // Данные для пейджера (названия подходов)

            // Состояние пейджера
            val pageState = rememberPagerState(initialPage = 0) {
                data.size
            }
            var initialEventTriggered by remember { mutableStateOf(false) }

            // Счетчик текущего упражнения (от 1 до 5)
            var count by remember { mutableStateOf(1) }

            // Список для отслеживания выполненных подходов
            val completedSets =
                remember {
                    mutableStateListOf<Boolean>().apply {
                        repeat(data.size) {
                            add(false)
                        }
                    }
                }
            val coroutineScope = rememberCoroutineScope()

            // Флаг, блокирующий свайп назад после завершения всех подходов
            var blockSwipeBack by remember { mutableStateOf(false) }

            // Индекс подхода, на котором кнопка активна
            var activeButtonIndex by remember { mutableStateOf(0) }

            // HorizontalPager для отображения подходов
            HorizontalPager(
                state = pageState,
                modifier = Modifier.fillMaxWidth(),
                userScrollEnabled = !blockSwipeBack         // Блокируем свайп назад, если blockSwipeBack = true
            )
            { page ->

                // Запускаем корутину при изменении текущей страницы пейджера
                LaunchedEffect(key1 = pageState.currentPage) {
                    // Получаем название текущего подхода
                    val exercise = data[pageState.currentPage]
                    // Проверяем, нужно ли отправить событие о начале подхода
                    if (!initialEventTriggered || pageState.currentPage != 0) {
                        initialEventTriggered = true

                        // Отправляем событие в зависимости от названия подхода
                        when (exercise) {
                            "1 set" -> onEvent.invoke(TrainingEvent.OneSet)
                            "2 set" -> onEvent.invoke(TrainingEvent.TwoSet)
                            "3 set" -> onEvent.invoke(TrainingEvent.ThreeSet)
                            "4 set" -> onEvent.invoke(TrainingEvent.FourSet)
                        }
                    }
                }

                // Отображаем экран с упражнениями для текущего подхода
                TestNormal(
                    state = state,
                    //, onEvent = onEvent
                    isCompleted = completedSets[page],
                    onCompleteClick = {

                        // Помечаем подход как выполненный
                        completedSets[page] = true

                        // Увеличиваем счетчик упражнений
                        count++

                        // Проверяем, все ли упражнения выполнены
                        if (count > 5) {

                            // Сбрасываем счетчик упражнений, так как упражнений всего 5
                            count = 1

                            // Проверяем, не последний ли это подход
                            if (pageState.currentPage < data.size - 1) {
                                // Если не последний, то автоматически переходим на следующий
                                coroutineScope.launch {
                                    pageState.animateScrollToPage(pageState.currentPage + 1)
                                }
                                // Блокируем свайп сразу после автоматического свайпа на следующий подход
                                blockSwipeBack = true

                                activeButtonIndex = pageState.currentPage + 1 // Активируем кнопку на следующем подходе
                            } else {
                                navController.navigate("details")
                            }
                        }
                    },
                    // Передаем текущее упражнение
                    countS = count,
                            allowButtonClick = page == activeButtonIndex // Кнопка активна только на текущем подходе

                )
            }

            // потом обязательно перенеси советы по упражнениям TestNormal, чтоб советы были связаны с конкретным пордходом
            AdviceForExersize()
        }
    }

}


@Composable
fun TrackEvent(eventName: String) {
    val firebaseAnalytics = Firebase.analytics
    val context = LocalContext.current

    DisposableEffect(Unit) {
        firebaseAnalytics.logEvent(eventName, null)
        onDispose { }
    }
}
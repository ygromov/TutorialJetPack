package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.details_screen.DetailsScreenEvent
import com.example.tutorialjetpack.presentation.screens.details_screen.DetailsState
import com.example.tutorialjetpack.presentation.screens.details_screen.components.OfpCounts
import com.example.tutorialjetpack.presentation.screens.retry_ofp.components.DetailsTopBar

/*
добавить запрос в базу данных и отобразить значения в табличку:
                        -за все время
                        -за месяц
                        -за неделю
                        -за день
добавить отображение пройденных тренировок
добавить фичу, которая при достижении 5 тренировок, советует пройти тестирование офп заново
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(state: DetailsState, onEvent: (DetailsScreenEvent) -> Unit) {

    //var progress by remember { mutableStateOf((state.pullMax % 10).toFloat()) }
    val max = 10f

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            DetailsTopBar(onEvent)

            Card(
                modifier = Modifier
                    //.alpha(0.7f)
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp),
                elevation = 8.dp,
                backgroundColor =MaterialTheme.colors.primaryVariant
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(modifier = Modifier.size(100.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.pullup),
                            contentDescription = ""
                        )
                    }


                    Column(modifier = Modifier.padding(start = 16.dp)) {

                        Text(
                            text = "name: ${state.name}", color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(top = 4.dp),
                            maxLines = 5,
                            overflow = TextOverflow.Visible
                        )

                        Text(
                            text = "age: ${state.age}",
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Text(
                            text = "height: ${state.height}", color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Text(
                            text = "weight: ${state.weight}", color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        // gender is not use in Europe XD
//                        Text(
//                            text = "gender: ${state.gender}", color = MaterialTheme.colors.primary,
//                            modifier = Modifier.padding(top = 4.dp)
//                        )
                    }
                }


            }
            Card(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .fillMaxWidth()
                ,elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primaryVariant
            ) {
            OfpCounts(
                pullMax = state.pullMax.toInt(),
                pushMax = state.pushMax.toInt(),
                sitMax = state.squatMax.toInt(),
                absMax = state.absMax.toInt(),
                extenMax = state.extensMax.toInt()
                )
        }

//            Card(
//                modifier = Modifier
//                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
//                    //.alpha(0.7f),
//                ,elevation = 8.dp,
//                backgroundColor = MaterialTheme.colors.primaryVariant
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(end = 8.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(text = "my Ofp level:", color = MaterialTheme.colors.primary)
//                        Text(text = "Level", color = MaterialTheme.colors.primary)
//                    }
//                    Row(
//                        modifier = Modifier.padding(top = 10.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Card(
//                            modifier = Modifier
//                                .width(70.dp)
//                                .height(20.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "Pull ups: ", color = MaterialTheme.colors.primary,
//                                fontSize = 15.sp,
//                                //modifier = Modifier
//                                    //.background(MaterialTheme.colors.background)
//                            )
//                        }
//                        Card(
//                            modifier = Modifier.padding(start = 4.dp),
//                            elevation = 8.dp
//                        ) {
//                            CustomLinearProgressIndicator(
//                                progress = (state.pullMax % 10).toFloat(),
//                                max = max
//                            )
//                        }
//                        Card(
//                            modifier = Modifier
//                                .padding(start = 4.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "${state.pullMax / 10}",
//                                color = MaterialTheme.colors.primary,
//                                maxLines = 1
//                            )
//                            //will add a result of analizeMax
//                        }
//                    }
//                    Row(modifier = Modifier.padding(top = 10.dp)) {
//                        Card(
//                            modifier = Modifier
//                                .width(70.dp)
//                                .height(20.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "Push ups: ", color = MaterialTheme.colors.primary,
//                                fontSize = 15.sp
//                            )
//                        }
//                        Card(
//                            modifier = Modifier.padding(start = 4.dp),
//                            elevation = 8.dp
//                        ) {
//                            CustomLinearProgressIndicator(
//                                progress = (state.pushMax % 10).toFloat(),
//                                max = max
//                            )
//                        }
//                        Card(
//                            modifier = Modifier
//                                .padding(start = 4.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "${state.pushMax / 10}", color = MaterialTheme.colors.primary
//                            )
//                        }
//                    }
//                    Row(modifier = Modifier.padding(top = 10.dp)) {
//                        Card(
//                            modifier = Modifier
//                                .width(70.dp)
//                                .height(20.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "Squats: ", color = MaterialTheme.colors.primary,
//                                fontSize = 15.sp
//                            )
//                        }
//                        Card(
//                            modifier = Modifier.padding(start = 4.dp),
//                            elevation = 8.dp
//                        ) {
//                            CustomLinearProgressIndicator(
//                                progress = (state.squatMax % 10).toFloat(),
//                                max = max
//                            )
//                        }
//                        Card(
//                            modifier = Modifier
//                                .padding(start = 4.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "${state.squatMax / 10}",
//                                color = MaterialTheme.colors.primary
//                            )
//                        }
//                    }
//                    Row(modifier = Modifier.padding(top = 10.dp)) {
//                        Card(
//                            modifier = Modifier
//                                .width(70.dp)
//                                .height(20.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "Sit ups: ", color = MaterialTheme.colors.primary,
//                                fontSize = 15.sp
//                            )
//                        }
//                        Card(
//                            modifier = Modifier.padding(start = 4.dp),
//                            elevation = 8.dp
//                        ) {
//                            CustomLinearProgressIndicator(
//                                progress = (state.absMax % 10).toFloat(),
//                                max = max
//                            )
//                        }
//                        Card(
//                            modifier = Modifier
//                                .padding(start = 4.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "${state.absMax / 10}", color = MaterialTheme.colors.primary
//                            )
//                        }
//                    }
//                    Row(modifier = Modifier.padding(top = 10.dp)) {
//                        Card(
//                            modifier = Modifier
//                                .width(70.dp)
//                                .height(20.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "Back ext: ", color = MaterialTheme.colors.primary,
//                                fontSize = 15.sp
//                            )
//                        }
//                        Card(
//                            modifier = Modifier.padding(start = 4.dp),
//                            elevation = 8.dp
//                        ) {
//                            CustomLinearProgressIndicator(
//                                progress = (state.extensMax % 10).toFloat(),
//                                max = max
//                            )
//                        }
//                        Card(
//                            modifier = Modifier
//                                .padding(start = 4.dp),
//                            elevation = 8.dp,
//                            backgroundColor = MaterialTheme.colors.primaryVariant
//                        ) {
//                            Text(
//                                text = "${state.extensMax / 10}",
//                                color = MaterialTheme.colors.primary
//                            )
//                        }
//                    }
//                }
//            }
            Card(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    //.alpha(0.7f)
                    .fillMaxWidth(),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.primaryVariant
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${state.countTraining}/5",
                        fontSize = 40.sp,
                        color = MaterialTheme.colors.primary
                    )
                    if (state.countTraining == 5L) {
                        Text(text = "get tested: Ofp Test", color = Color.Red)
                    } else Text(text = "completed workouts")
                }
            }

            //тестовая кнопка переход для отладки недоступных экранов
            Button(onClick = { onEvent.invoke(DetailsScreenEvent.ToFirstScreen) }) {
                Text(text = "toFirstScreen")
            }
        }
    }
}

@Composable
fun CustomLinearProgressIndicator(
    progress: Float,
    max: Float,
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        progress = progress / max,
        modifier = modifier
            //.padding(start = 15.dp, end = 12.dp)
            .drawWithContent {
                drawContent()
                val paint = Paint().apply {
                    isAntiAlias = true
                    color = Color.Black.toArgb()
                    textSize = 50f
                }
                val text = "to the next level: $progress / $max"
                drawContext.canvas.nativeCanvas.drawText(text, 0f, size.height / 2f, paint)
            }
            .fillMaxHeight(0.05f),
        color = MaterialTheme.colors.surface,
        backgroundColor = MaterialTheme.colors.secondary
    )
}
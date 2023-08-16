package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.OriginalSize
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingEvent
import com.example.tutorialjetpack.presentation.screens.training_screen.TrainingState
import com.example.tutorialjetpack.utils.Routers
import kotlinx.coroutines.delay

private const val TAG = "TrainingScreen"

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@SuppressLint("UnrememberedMutableState")
@Composable
fun TrainingScreen(
    state: TrainingState,
    navController: NavController,
    onEvent: (TrainingEvent) -> Unit,
) {         //вот сюда передали


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.background_gradient),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.4f
        )

        // Состояние прокрутки
        val scrollState = rememberLazyListState()

        // Индекс текущего элемента
        var currentIndex by remember { mutableStateOf(0) }

        // CoroutineScope для асинхронных операций
        val coroutineScope = rememberCoroutineScope()

        var isVisiblePull by remember { mutableStateOf(true) }
        var isVisiblePush by remember { mutableStateOf(false) }
        var isVisibleSquat by remember { mutableStateOf(false) }
        var isVisibleAbs by remember { mutableStateOf(false) }
        var isVisibleExtens by remember { mutableStateOf(false) }

        Column() {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, end = 16.dp)
            ) {

                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 16.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = MaterialTheme.colors.primary
                    ),
                    onClick = {
                        navController.navigate(Routers.DETAILS.route)
                    }) {
                    Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                }
                Button(
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 16.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        contentColor = MaterialTheme.colors.primary
                    ),
                    onClick = {
                        navController.navigate(Routers.JOURNAL.route)
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = ""
                    )
                }


            }
            LazyRow(
                state = scrollState, modifier = Modifier
                    .fillMaxWidth()
            ) {
                item {
                    if (isVisiblePull) {
                        Row(
                            Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.7f)
                                    .padding(4.dp)
                                    .alpha(0.7f)
                                    .fillMaxWidth(0.9f)
                                    .background(MaterialTheme.colors.background),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = state.headText,
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 30.sp
                                )
                                Text(
                                    text = "Pull ups",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 26.sp
                                )
                                GifPush(R.drawable.pullupsgif)
                                Text(
                                    text = "${state.pull} reps",
                                    color = MaterialTheme.colors.primary, fontSize = 24.sp
                                )
                                Timer(value1 = 120)
                            }
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisiblePull = false
                                        isVisiblePush = true
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_next_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }

                }
                item {
                    if (isVisiblePush) {
                        Row(
                            Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisiblePull = true
                                        isVisiblePush = false
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth(0.08f)
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_back2_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(16.dp)
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.7f)
                                    .padding(4.dp)
                                    .alpha(0.7f)
                                    .fillMaxWidth(0.88f)
                                    .background(MaterialTheme.colors.background),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = state.headText,
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 30.sp
                                )
                                Text(
                                    text = "Push ups",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 26.sp
                                )
                                GifPush(R.drawable.pushups)
//                                Image(
//                                    painter = painterResource(id = R.drawable.pushup),
//                                    contentDescription = ""
//                                )
                                Text(
                                    text = "${state.push} reps",
                                    color = MaterialTheme.colors.primary, fontSize = 24.sp
                                )
                                Timer(value1 = 120)
                            }
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleSquat = true
                                        isVisiblePush = false
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_next_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                }

                item {
                    if (isVisibleSquat) {
                        Row(
                            Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleSquat = false
                                        isVisiblePush = true
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth(0.08f)
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_back2_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(16.dp)
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.7f)
                                    .padding(4.dp)
                                    .alpha(0.7f)
                                    .fillMaxWidth(0.88f)
                                    .background(MaterialTheme.colors.background),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = state.headText,
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 30.sp
                                )
                                Text(
                                    text = "Squat",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 26.sp
                                )
                                GifPush(R.drawable.squatsgif)
                                Text(
                                    text = "${state.squat} reps",
                                    color = MaterialTheme.colors.primary, fontSize = 24.sp
                                )
                                Timer(value1 = 120)
                            }
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleSquat = false
                                        isVisibleAbs = true
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_next_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                }
                item {
                    if (isVisibleAbs) {
                        Row(
                            Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleAbs = false
                                        isVisibleSquat = true
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth(0.08f)
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_back2_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(16.dp)
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.7f)
                                    .padding(4.dp)
                                    .alpha(0.7f)
                                    .fillMaxWidth(0.88f)
                                    .background(MaterialTheme.colors.background),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = state.headText,
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 30.sp
                                )
                                Text(
                                    text = "Sit ups",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 26.sp
                                )
                                GifPush(data = R.drawable.situpsgif)
                                Text(
                                    text = "${state.abc} reps",
                                    color = MaterialTheme.colors.primary, fontSize = 24.sp
                                )
                                Timer(value1 = 120)
                            }
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleAbs = false
                                        isVisibleExtens = true
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_next_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                }
                item {
                    if (isVisibleExtens) {
                        Row(
                            Modifier
                                .fillParentMaxWidth()
                                .padding(8.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleExtens = false
                                        isVisibleAbs = true
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth(0.08f)
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_back2_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .size(16.dp)
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.7f)
                                    .padding(4.dp)
                                    .alpha(0.7f)
                                    .fillMaxWidth(0.88f)
                                    .background(MaterialTheme.colors.background),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = state.headText,
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 30.sp
                                )
                                Text(
                                    text = "Back extension",
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 26.sp
                                )
                                GifPush(data = R.drawable.backextensiongif)
                                Text(
                                    text = "${state.extens} reps",
                                    color = MaterialTheme.colors.primary, fontSize = 24.sp
                                )
                                Timer(value1 = 120)
                            }
                            Card(
                                modifier = Modifier
                                    .clickable {
                                        isVisibleExtens = false
                                        isVisiblePull = true
                                        if (state.headText == "1 set") {
                                            onEvent.invoke(TrainingEvent.TwoSet)
                                        } else if (state.headText == "2 set") {
                                            onEvent.invoke(TrainingEvent.ThreeSet)
                                        } else if (state.headText == "3 set") {
                                            onEvent.invoke(TrainingEvent.FourSet)
                                        } else if (state.headText == "4 set") {
                                            navController.navigate(Routers.DETAILS.route)
                                            onEvent.invoke(TrainingEvent.TrainingCount)
                                        }
                                    }
                                    .padding(start = 4.dp, end = 4.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.7f),
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.navigate_next_24),
                                        contentDescription = "Стрелка",
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Card(modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .background(MaterialTheme.colors.background)
                .alpha(0.7f)) {
                Column(modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .alpha(0.7f)) {
                    Text(text = "Advice: ", fontSize = 20.sp, textAlign = TextAlign.Center)
                    Text(text = "Before training, do a good warm-up, as warmed up muscles increase the efficiency of the workout.")
                }
            }
        }
    }
}

@Composable
fun Timer(value1: Int) {
    var value by remember { mutableStateOf(value1) }
    LaunchedEffect(key1 = value) {
        while (value > 0) {
            delay(1000)
            value -= 1
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "your rest: ${value}", color = Color.Black, fontSize = 24.sp)
        Button(
            onClick = { value += 20 },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(text = "+ 20 sec", color = MaterialTheme.colors.primary)
        }
    }
}

@Composable
fun GifPush(
    data: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder(context))
            } else {
                add(GifDecoder())
            }
        }
        .build()

    Image(
        painter = rememberImagePainter(
            imageLoader = imageLoader,
            data = data,
            builder = {
                size(OriginalSize)
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .padding(top = 4.dp)
    )
}

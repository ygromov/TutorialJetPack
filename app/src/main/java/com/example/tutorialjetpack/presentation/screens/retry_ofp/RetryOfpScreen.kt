package com.example.tutorialjetpack.presentation

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.OriginalSize
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.retry_ofp.RetryOfpEvent
import com.example.tutorialjetpack.presentation.screens.retry_ofp.RetryOfpState
import com.example.tutorialjetpack.presentation.screens.retry_ofp.components.RetryOfpMainItem
import com.example.tutorialjetpack.presentation.screens.retry_ofp.components.RetryTimer

private const val TAG = "RetryOfpScreen"

@SuppressLint("UnrememberedMutableState")
@Composable
fun RetryOfpScreen(state: RetryOfpState, onEvent: (RetryOfpEvent) -> Unit) {
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
        var test by remember {
            mutableStateOf(1)
        }
        var isPushSelected by remember { mutableStateOf(false) }


        Column(modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp).alpha(0.7f)) {
            Row(modifier = Modifier
                .fillMaxWidth()
               , horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Hello, ${state.name}")
                RetryOfpMainItem(onEvent)      //переходы на тренировки, журнал, офпТест

            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Card(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        when (test) {
                            1 -> InputPush("Pull ups", R.drawable.pullupsgif, state.userPhysiqLevel) {
                                isPushSelected = true
                                onEvent.invoke(RetryOfpEvent.ChangePull(it))
                            }

                            2 -> InputPush("Push ps", R.drawable.pushups, state.userPhysiqLevel) {
                                isPushSelected = true
                                onEvent.invoke(RetryOfpEvent.ChangePush(it))
                            }

                            3 -> InputPush("Squats", R.drawable.squatsgif, state.userPhysiqLevel) {
                                isPushSelected = true
                                onEvent.invoke(RetryOfpEvent.ChangeSquat(it))
                            }

                            4 -> InputPush("Sit ups", R.drawable.situpsgif, state.userPhysiqLevel) {
                                isPushSelected = true
                                onEvent.invoke(RetryOfpEvent.ChangeAbs(it))
                            }

                            5 -> InputPush("Back extension", R.drawable.backextensiongif, state.userPhysiqLevel) {
                                isPushSelected = true
                                onEvent.invoke(RetryOfpEvent.ChangeExtens(it))
                            }

                            else -> {
                                test = 1
                                onEvent.invoke(RetryOfpEvent.BtnAnalize)
                            }
                        }
                    }
                }
//                Card(
//                    modifier = Modifier
//                        .padding(start = 8.dp, end = 8.dp, top = 16.dp)
//                        .fillMaxWidth(),
//                    backgroundColor = MaterialTheme.colors.background
//
//                ) {
                    Button(
                        onClick = {
                            if (isPushSelected) {
                                test = test + 1
                                isPushSelected=false
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primaryVariant,
                            contentColor = MaterialTheme.colors.primary
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "next")
                    }
               // }
            }
        }
    }
}

@Composable
fun InputPush(name: String, image: Int, timer: Long, onEvent: (Int) -> Unit) {
    var push by remember { mutableStateOf(0) }
    val pushRange = 0..150
    val listStatePush = rememberLazyListState(18)
    var visiblePush by remember { mutableStateOf(false) }
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

    Column(horizontalAlignment = Alignment.CenterHorizontally) {      //age
        Text(text = name, modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp))
        Text(
            text = "do as many $name as you can in ${timer} seconds",
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
        )

        Image(
            painter = rememberImagePainter(
                imageLoader = imageLoader,
                data = image,
                builder = {
                    size(OriginalSize)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "your result: ", color = MaterialTheme.colors.primary)

            Card(
                elevation = 10.dp,
                border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = push.toString(), color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .clickable {
                            visiblePush = !visiblePush
                        }
                )
            }
        }
        if (visiblePush) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentHeight()
                    .wrapContentSize(align = Alignment.Center)
            ) {

                Box(
                    modifier = Modifier
                        .size(height = 100.dp, width = 200.dp)
                        .background(MaterialTheme.colors.secondary)
                ) {
                    LazyColumn(state = listStatePush) {
                        itemsIndexed(items = pushRange.toList()) { index, it ->
                            WeightItems(
                                text = "${it} reps",
                                isSelected = push == it,
                                onClick = {
                                    //isKgSelected = true
                                    push = it
                                }
                            )
                        }
                    }
                }
            }
            Button(
                onClick = {
                        onEvent.invoke(push)
                        visiblePush = false
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = MaterialTheme.colors.primary
                ),
            ) {
                Text(text = "Complete", color = MaterialTheme.colors.primary)
            }
        }
        RetryTimer(
            totalTime = timer * 1000L,
            handleColor = Color.Red,
            inactiveBarColor = Color.DarkGray,
            activeBarColor = Color.Red,    //(0xFF37B900),
            modifier = Modifier.size(200.dp)
        )
    }
}
@Composable
fun WeightItems(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = text,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(if (isSelected) Color.Gray else Color.Transparent)
            .clickable { onClick() }
    )
}
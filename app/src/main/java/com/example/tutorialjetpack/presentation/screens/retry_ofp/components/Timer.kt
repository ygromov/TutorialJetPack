package com.example.tutorialjetpack.presentation.screens.retry_ofp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun RetryTimer(
    totalTime: Long,
    handleColor: Color,
    inactiveBarColor: Color,
    activeBarColor: Color,
    modifier: Modifier = Modifier,
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var value by remember {
        mutableStateOf(initialValue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .onSizeChanged {
                    size = it
                }
        ) {
            Canvas(modifier = modifier) {
                drawArc(
                    color = inactiveBarColor,
                    startAngle = -215f,
                    sweepAngle = 250f,
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = activeBarColor,
                    startAngle = -215f,
                    sweepAngle = 250f * value,
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                val center = Offset(size.width / 2f, size.height / 2f)
                val beta = (250f * value + 145f) * (Math.PI / 180f).toFloat()
                val r = size.width / 2f
                val a = cos(beta) * r
                val b = sin(beta) * r
                drawPoints(
                    listOf(Offset(center.x + a, center.y + b)),
                    pointMode = PointMode.Points,
                    color = handleColor,
                    strokeWidth = (strokeWidth * 3f).toPx(),
                    cap = StrokeCap.Round
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = (currentTime / 1000L).toString(),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Button(
                    onClick = {
                        if (currentTime <= 0L || currentTime < 60000L) {
                            currentTime = totalTime
                            isTimerRunning = true
                        } else {
                            isTimerRunning = !isTimerRunning
                        }
                    },
                    //modifier = Modifier.align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (!isTimerRunning || currentTime <= 0L) {
                            MaterialTheme.colors.primaryVariant
                        } else {
                            Color.Red
                        }
                    )
                ) {
                    Text(
                        text = if (isTimerRunning && currentTime >= 0L) "Try"
                        else if (!isTimerRunning && currentTime >= 0L) "Start"
                        else "Restart",
                        color = MaterialTheme.colors.primary
                    )
                }
                Button(
                    onClick = {

                        isTimerRunning = false
                        currentTime = totalTime
                    },
                    //modifier = Modifier.align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red

                    )
                ) {
                    Text(
                        text = "Stop",
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}
package com.example.tutorialjetpack.presentation.screens.exercise_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.domain.model.ExerciseFieldModel

@Composable
fun ExerciseField(
    exerciseFieldModel: ExerciseFieldModel,
    //state2: MutableStateFlow<Resource<OfpModel>>
) {
    Card() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = exerciseFieldModel.icon),
                contentDescription = "image_icon_exercise"
            )
            Text(text = exerciseFieldModel.nameExerscise)
            Text(
                text = exerciseFieldModel.value.toString(),
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}
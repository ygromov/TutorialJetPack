package com.example.tutorialjetpack.presentation.screens.exercise_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.tutorialjetpack.domain.model.ExerciseFieldModel

@Composable
fun ExerciseField(
    exerciseFieldModel: ExerciseFieldModel,
    //state2: MutableStateFlow<Resource<OfpModel>>
) {
    Card() {
        Row() {
            Icon(
                imageVector = ImageVector.vectorResource(id = exerciseFieldModel.icon),
                contentDescription = "image_icon_exercise"
            )
            Text(text = exerciseFieldModel.nameExerscise)
            Text(text = exerciseFieldModel.value.toString())
        }
    }
}
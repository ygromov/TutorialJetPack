package com.example.tutorialjetpack.presentation.screens.exercise_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.tutorialjetpack.domain.model.ExerciseFieldModel

@Composable
fun ExerciseItem(exercise: List<ExerciseFieldModel>) {
    LazyColumn(){
        items(exercise){
            ExerciseField(exerciseFieldModel = it)
        }
    }
}
//error commit
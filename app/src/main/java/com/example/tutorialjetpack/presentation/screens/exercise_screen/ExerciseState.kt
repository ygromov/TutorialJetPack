package com.example.tutorialjetpack.presentation.screens.exercise_screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.ExerciseFieldModel

data class ExerciseState (
val UserId: Int = -1,
val list: SnapshotStateList<ExerciseFieldModel> = mutableStateListOf(
    ExerciseFieldModel(
        icon = R.drawable.ic_launcher_foreground,
        nameExerscise = "pushUp",
        value =  0
    ),
    ExerciseFieldModel(
        icon = R.drawable.ic_launcher_foreground,
        nameExerscise = "pullUp",
        value =  0
    ),
    ExerciseFieldModel(
        icon = R.drawable.ic_launcher_foreground,
        nameExerscise = "squat",
        value =  0
    ),
    ExerciseFieldModel(
        icon = R.drawable.ic_launcher_foreground,
        nameExerscise = "abc",
        value =  0
    ),
    ExerciseFieldModel(
        icon = R.drawable.ic_launcher_foreground,
        nameExerscise = "extens",
        value =  0
    )

)
)
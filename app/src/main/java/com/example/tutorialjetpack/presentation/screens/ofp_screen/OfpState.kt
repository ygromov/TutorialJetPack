package com.example.tutorialjetpack.presentation.screens.ofp_screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.OfpFieldModel

data class OfpState(
    val userId: Int = -1,
    val list: SnapshotStateList<OfpFieldModel> = mutableStateListOf(
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "push",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "pull",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "squat",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "abc",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "extens",
            value = "0"
        )
    )
//    val push: String="0",
//    val pull: String="0",
//    val squat: String="0",
//    val abc: String="0",
//    val extens: String="0"
)
//error commit
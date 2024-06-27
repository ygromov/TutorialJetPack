package com.example.tutorialjetpack.presentation.screens.ofp_screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.OfpFieldModel

data class OfpState(
    val name: String = "",
    val userId: Int = -1,
    val userPhysLevel: Long = -1L,
    val push: Int = -1,
    val pull: Int = -1,
    val squat: Int = -1,
    val abs: Int = -1,
    val extens: Int = -1,
    val list: SnapshotStateList<OfpFieldModel> = mutableStateListOf(
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "push ups",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "pull ups",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "sit ups",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "abs",
            value = "0"
        ),
        OfpFieldModel(
            icon = R.drawable.ic_launcher_foreground,
            textNameExersize = "back extension",
            value = "0"
        )
    )
)
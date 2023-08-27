package com.example.tutorialjetpack.presentation.screens.training_screen

data class TrainingState(
    val name: String = "",
    val headText: String = "Please, press button: 1 set",
    val UserId: Int = -1,
    val push: Int=-1,
    val pull: Int=-1,
    val squat: Int=-1,
    val abc: Int=-1,
    val extens: Int=-1,
    val flag: Int = -1,
    val level: Long = -1,

    var pushUpSets: Int = -1,
    var pullUpSets: Int = -1,
    var squatSets: Int = -1,
    var sitUpSets: Int = -1,
    var extensSets: Int = -1
)
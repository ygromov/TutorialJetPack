package com.example.tutorialjetpack.presentation.screens.details_screen

data class DetailsState(
    val name: String = "",
    val age:Int= 0,
    val height:Double= 0.0,
    val weight:Double= 0.0,
    val gender: String = "",
    val push: Int = 0,
    val pull: Int = 0,
    val squat: Int = 0,
    val abs: Int = 0,
    val extens: Int = 0,
    val pushMax: Long = 0,
    val pullMax: Long = 0,
    val squatMax: Long = 0,
    val absMax: Long = 0,
    val extensMax: Long = 0,
    val countTraining: Long = 0,
    val maxPush: Int = 0
)

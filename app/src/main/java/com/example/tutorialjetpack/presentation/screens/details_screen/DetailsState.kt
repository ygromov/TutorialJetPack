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
    val extens: Int = 0
)

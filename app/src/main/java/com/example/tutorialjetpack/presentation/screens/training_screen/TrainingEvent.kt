package com.example.tutorialjetpack.presentation.screens.training_screen

sealed class TrainingEvent{
    object CompleteSet: TrainingEvent()
    object TwoSet: TrainingEvent()
    object ThreeSet: TrainingEvent()
    object FourSet: TrainingEvent()
}
//error commit
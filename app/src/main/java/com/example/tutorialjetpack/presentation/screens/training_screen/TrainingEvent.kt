package com.example.tutorialjetpack.presentation.screens.training_screen

sealed class TrainingEvent{
    object OneSet: TrainingEvent()
    object TwoSet: TrainingEvent()
    object ThreeSet: TrainingEvent()
    object FourSet: TrainingEvent()
    object TrainingCount: TrainingEvent()
}
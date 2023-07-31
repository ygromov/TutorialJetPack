package com.example.tutorialjetpack.presentation.screens.first_screen

sealed class FirstScreenEvent {
    data class ChangeGender(val value: String) : FirstScreenEvent()
    data class ChangeName(val value: String) : FirstScreenEvent()
    data class ChangeAge(val value: String) : FirstScreenEvent()
    data class ChangeHeight(val value: String) : FirstScreenEvent()
    data class ChangeWeight(val value: String) : FirstScreenEvent()
    data class ChangeBody(val value: String) : FirstScreenEvent()
    data class ChangeActiv(val value: String) : FirstScreenEvent()
    data class ChangePhysiqLevel(val value: Long) : FirstScreenEvent()
    object Complete : FirstScreenEvent()
}
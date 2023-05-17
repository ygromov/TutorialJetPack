package com.example.tutorialjetpack.presentation.screens.first_screen

sealed class FirstScreenEvent{
    data class ChangeGender(val value: String): FirstScreenEvent()
    data class ChangeAge(val value:Int): FirstScreenEvent()
    data class ChangeHeight(val value:Int): FirstScreenEvent()
    data class ChangeWeight(val value:Int): FirstScreenEvent()
    object Complete: FirstScreenEvent()
}

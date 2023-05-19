package com.example.tutorialjetpack.presentation.screens.first_screen

sealed class FirstScreenEvent{
    data class ChangeGender(val value: String): FirstScreenEvent()
    data class ChangeAge(val value:String): FirstScreenEvent()
    data class ChangeHeight(val value:String): FirstScreenEvent()
    data class ChangeWeight(val value:String): FirstScreenEvent()
    object Complete: FirstScreenEvent()
}

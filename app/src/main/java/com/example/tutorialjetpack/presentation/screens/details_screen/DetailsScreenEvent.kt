package com.example.tutorialjetpack.presentation.screens.details_screen

sealed class DetailsScreenEvent {
    object GetUserInfo: DetailsScreenEvent()
    object GetOfp: DetailsScreenEvent()
    object ToOfpScreen: DetailsScreenEvent()
    object ToTrainingScreen: DetailsScreenEvent()
    object ToJournalScreen: DetailsScreenEvent()
    //add a ChangeWeight() and ChangeHeight()
}
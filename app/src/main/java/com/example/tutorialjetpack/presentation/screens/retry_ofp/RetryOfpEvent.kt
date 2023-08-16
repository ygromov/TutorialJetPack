package com.example.tutorialjetpack.presentation.screens.retry_ofp

sealed class RetryOfpEvent {
    data class ChangeOfpItem(val value: String, val index: Int) : RetryOfpEvent()
    object BtnAnalize : RetryOfpEvent()
    object BtnTraining : RetryOfpEvent()
    object BtnJournal : RetryOfpEvent()
    object BtnDetails : RetryOfpEvent()
    data class ChangePush(val value: Int) : RetryOfpEvent()
    data class ChangePull(val value: Int) : RetryOfpEvent()
    data class ChangeSquat(val value: Int) : RetryOfpEvent()
    data class ChangeAbs(val value: Int) : RetryOfpEvent()
    data class ChangeExtens(val value: Int) : RetryOfpEvent()

}

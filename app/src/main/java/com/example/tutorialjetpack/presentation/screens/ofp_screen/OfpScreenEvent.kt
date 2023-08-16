package com.example.tutorialjetpack.presentation.screens.ofp_screen


sealed class OfpScreenEvent{
    data class ChangeOfpItem(val value:String,val index:Int):OfpScreenEvent()
    object BtnAnalize:OfpScreenEvent()
    object BtnTraining:OfpScreenEvent()
    object BtnJournal:OfpScreenEvent()
    object BtnDetails:OfpScreenEvent()
    data class ChangePush(val value: Int) : OfpScreenEvent()
    data class ChangePull(val value: Int) : OfpScreenEvent()
    data class ChangeSquat(val value: Int) : OfpScreenEvent()
    data class ChangeAbs(val value: Int) : OfpScreenEvent()
    data class ChangeExtens(val value: Int) : OfpScreenEvent()

}
package com.example.tutorialjetpack.presentation.screens.ofp_screen



sealed class OfpScreenEvent{
    data class ChangeOfpItem(val value:String,val index:Int):OfpScreenEvent()
//    data class ChangePush(val value: String): OfpScreenEvent()


//    data class Navigate(val route:String):OfpScreenEvent()
    object BtnAnalize:OfpScreenEvent()
    object BtnTraining:OfpScreenEvent()
    object BtnJournal:OfpScreenEvent()
    object BtnDetails:OfpScreenEvent()

}
//error commit
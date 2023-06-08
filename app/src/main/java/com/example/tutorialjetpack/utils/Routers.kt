package com.example.tutorialjetpack.utils

sealed class Routers(val route: String){
    object OFP: Routers("ofp")
    object JOURNAL: Routers("journal")
    object TRAINING: Routers("training")
    object DETAILS: Routers("details")
    object FIRST: Routers("first")
    object EXERCISE: Routers("exercise")
}
//error commit
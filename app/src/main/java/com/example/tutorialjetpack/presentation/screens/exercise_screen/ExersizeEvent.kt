package com.example.tutorialjetpack.presentation.screens.exercise_screen

sealed class ExersizeEvent {
    data class appName(val value: String) : ExersizeEvent()
    data class userName(val value: String) : ExersizeEvent()
    data class gender(val value: String) : ExersizeEvent()
    data class age(val value: String) : ExersizeEvent()
    data class height(val value: String) : ExersizeEvent()
    data class weight(val value: String) : ExersizeEvent()
    data class body(val value: String) : ExersizeEvent()
    data class activ(val value: String) : ExersizeEvent()
}

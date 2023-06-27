package com.example.tutorialjetpack.domain.model

data class TrainingValue(

    var age: Int = -1,
    var weight: Double = -1.0,
    var height: Double = -1.0,

    var pushUp: Int = -1,
    var pullUp: Int = -1,
    var squat: Int = -1,
    var abs: Int = -1,
    var extens: Int = -1,

    var pushUpSets: Int = -1,
    var pullUpSets: Int = -1,
    var squatSets: Int = -1,
    var sitUpSets: Int = -1,
    var extensSets: Int = -1,

    var pushUpReps: Int = -1,
    var pullUpReps: Int = -1,
    var squatReps: Int = -1,
    var sitUpReps: Int = -1,
    var extensReps: Int = -1,
)

package com.example.tutorialjetpack.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tutorialjetpack.domain.model.OfpModel
import java.util.Date


@Entity(tableName = "ofpEntity")
data class OfpEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val userId: Int,
    val push:Int,
    val pull:Int,
    val squat:Int,
    val abc:Int,
    val extens:Int,
    val created: Date = Date()
    //TODO datetime object
)

fun OfpEntity.toOfpModel(): OfpModel{
    return OfpModel(
        userId = userId,
        push = push,
        pull = pull,
        squat = squat,
        abc = abc,
        extens = extens
    )
}

fun OfpModel.toOfpEntity(): OfpEntity{
    return OfpEntity(
        userId = userId,
        push = push,
        pull = pull,
        squat = squat,
        abc = abc,
        extens = extens
    )
}
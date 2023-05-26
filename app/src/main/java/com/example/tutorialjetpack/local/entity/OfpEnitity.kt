package com.example.tutorialjetpack.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tutorialjetpack.domain.model.OfpModel


@Entity(tableName = "ofpEntity")
data class OfpEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val userId: Int,
    val push:Int,
    val pull:Int,
    val squat:Int,
    val abc:Int,
    val extens:Int
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

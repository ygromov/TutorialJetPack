package com.example.tutorialjetpack.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tutorialjetpack.domain.model.UserModel


@Entity(tableName = "userEntity")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val age: Int,
    val name:String,
    val gender:String,
    val height: Int,
    val weight:Int,
)

fun UserEntity.toUserModel():UserModel{
    return UserModel(
        name = name,
        age = age,
        gender = gender,
        height = height,
        weight = weight
    )
}

fun UserModel.toUserEntity(): UserEntity {
    return UserEntity(
        name = name,
        age = age,
        gender = gender,
        height = height,
        weight = weight
    )
}
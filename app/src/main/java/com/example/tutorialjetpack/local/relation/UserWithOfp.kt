package com.example.tutorialjetpack.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tutorialjetpack.local.OfpEntity
import com.example.tutorialjetpack.local.entity.UserEntity

data class UserWithOfp(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val ofps: List<OfpEntity>
    )
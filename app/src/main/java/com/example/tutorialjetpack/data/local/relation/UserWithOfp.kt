package com.example.tutorialjetpack.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tutorialjetpack.data.local.entity.UserEntity
import com.example.tutorialjetpack.local.OfpEntity

data class UserWithOfp(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val ofps: List<OfpEntity>
    )
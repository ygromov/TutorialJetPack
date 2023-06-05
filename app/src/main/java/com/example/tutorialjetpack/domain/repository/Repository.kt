package com.example.tutorialjetpack.domain.repository

import com.example.tutorialjetpack.domain.model.OfpModel
import com.example.tutorialjetpack.domain.model.UserModel
import com.example.tutorialjetpack.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun addUserData(user:UserModel): Flow<Resource<UserModel>>

    fun addOfpData(ofp: OfpModel): Flow<Resource<OfpModel>>

    suspend fun getId():Long?

    suspend fun getUserOfp(): Flow<Resource<OfpModel>>


    //fun getUserData(id:Int): Flow<Resource<UserModel>>
}
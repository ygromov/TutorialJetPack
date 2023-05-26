package com.example.tutorialjetpack.local.repositoryImpl

import com.example.tutorialjetpack.domain.model.OfpModel
import com.example.tutorialjetpack.domain.model.UserModel
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.local.OfpDao
import com.example.tutorialjetpack.local.entity.toUserEntity
import com.example.tutorialjetpack.local.entity.toUserModel
import com.example.tutorialjetpack.local.toOfpEntity
import com.example.tutorialjetpack.local.toOfpModel
import com.example.tutorialjetpack.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val ofpDao: OfpDao
) : Repository {

    override fun addUserData(user: UserModel): Flow<Resource<UserModel>> = flow {
        emit(Resource.Loading())
        try {
            val userEntity = user.toUserEntity()
            ofpDao.insertUserEntity(userEntity)
            emit(Resource.Success(userEntity.toUserModel()))
        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))
        }
        emit(Resource.Loading(isLoading = false))
    }

    override fun addOfpData(ofp: OfpModel): Flow<Resource<OfpModel>> = flow {
        emit(Resource.Loading())
        try {
            val ofpEntity = ofp.toOfpEntity()
            ofpDao.insertOfpEntity(ofpEntity)
            emit(Resource.Success(ofpEntity.toOfpModel()))
        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))
        }
        emit(Resource.Loading(isLoading = false))
    }

}
package com.example.tutorialjetpack.data.repositoryImpl

import android.util.Log
import com.example.tutorialjetpack.data.datastore.AppDataStore
import com.example.tutorialjetpack.data.local.OfpDao
import com.example.tutorialjetpack.data.local.entity.toUserEntity
import com.example.tutorialjetpack.data.local.entity.toUserModel
import com.example.tutorialjetpack.domain.model.MonthValue
import com.example.tutorialjetpack.domain.model.OfpModel
import com.example.tutorialjetpack.domain.model.UserModel
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.local.toOfpEntity
import com.example.tutorialjetpack.local.toOfpModel
import com.example.tutorialjetpack.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "RepositoryImpl"

 class RepositoryImpl @Inject constructor(               //реализация интерфейса из domain слоя
    private val appDataStoreManager: AppDataStore,
    private val ofpDao: OfpDao
) : Repository {

    override fun addUserData(user: UserModel): Flow<Resource<UserModel>> = flow {
        emit(Resource.Loading())
        try {
            val userEntity = user.toUserEntity()
            val id = ofpDao.insertUserEntity(userEntity)
            //sharedPref save id
            appDataStoreManager.setValue("userId", id)
            emit(Resource.Success(userEntity.toUserModel()))
        } catch (ex: Exception) {
            Log.d(TAG, "addUserData: $ex")
            emit(Resource.Error(message = "Error"))
        }
        emit(Resource.Loading(isLoading = false))
    }

    override fun addOfpData(ofp: OfpModel): Flow<Resource<OfpModel>> = flow {
        emit(Resource.Loading())
        try {
            val ofpEntity = ofp.toOfpEntity() //конвертировали в ентити
            ofpDao.insertOfpEntity(ofpEntity)           //отправили данные в БД
            emit(Resource.Success(ofpEntity.toOfpModel())) // отправили данные во флоу
        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))
        }
        emit(Resource.Loading(isLoading = false))
    }

    override suspend fun getId(): Long? {
        return appDataStoreManager.readValue("userId")
    }

    override suspend fun getUserOfp(): Flow<Resource<OfpModel>> = flow {
        emit(Resource.Loading())
        try {
            val userId = appDataStoreManager.readValue("userId")
            val ofpEntity = ofpDao.getUserOfp(userId = userId!!.toInt()) //взяли данные из БД, это офпЭнтити

            Log.d(TAG, "getUserOfp5: $ofpEntity")
            emit(Resource.Success(ofpEntity.toOfpModel()))
            Log.d(TAG, "getUserOfp6: ${ofpEntity.toOfpModel()}")

        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))
        } finally {
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun getPullUp(): List<MonthValue> {
        Log.d(TAG, "getPullUp: ${ofpDao.maxPullUp()}")
        return ofpDao.maxPullUp()
    }

     override fun getUserData(): Flow<Resource<UserModel>> = flow {
         emit(Resource.Loading())
         try {
             val userId = appDataStoreManager.readValue("userId")
             val userEntity = ofpDao.getUserInfoById(id = userId!!.toInt())
             Log.d(TAG, "getUserData5: $userEntity")
             emit(Resource.Success(userEntity.toUserModel()))
             Log.d(TAG, "getUserData6: ${userEntity.toUserModel()}")
         }
         catch (ex: Exception) {
             emit(Resource.Error(message = "Error"))
         } finally {
             emit(Resource.Loading(isLoading = false))
         }
     }
 }
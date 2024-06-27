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

 class
 RepositoryImpl @Inject constructor(               //реализация интерфейса из domain слоя
    private val appDataStoreManager: AppDataStore,  //менджер для работа с DataStore
    private val ofpDao: OfpDao                      //объект Dao для работы с базой данных
) : Repository {

    //метод для добавления данных юзера в базу данных Room
    override fun addUserData(user: UserModel): Flow<Resource<UserModel>> = flow {
        emit(Resource.Loading())                    //отправлчяем сообщение о загрузке
        try {
            val userEntity = user.toUserEntity()        //конвертим модель UserModel в сущность(энтити) UserEntity
            val id = ofpDao.insertUserEntity(userEntity)    //добавляем сущность(данные) в базу данных и получаем ее id
            //sharedPref save id
            appDataStoreManager.setValue("userId", id)              //сохраняем в DataStore полученный id под ключем "userId"
            emit(Resource.Success(userEntity.toUserModel()))        //отправляем в Flow модель UserModel
        } catch (ex: Exception) {
            Log.d(TAG, "addUserData: $ex")
            emit(Resource.Error(message = "Error"))                 //отправляем сообщение об ошибке в Flow
        }
        emit(Resource.Loading(isLoading = false))                   //завершаем загрузку установкой флага в false
    }

     //метод для добавления офп юзера в базу данных Room
    override fun addOfpData(ofp: OfpModel): Flow<Resource<OfpModel>> = flow {
        emit(Resource.Loading())
        try {
            val ofpEntity = ofp.toOfpEntity()               //конвертим модель OfpModel в энтити OfpEntity
            ofpDao.insertOfpEntity(ofpEntity)                        //добавлеям данные в БД
            emit(Resource.Success(ofpEntity.toOfpModel()))          // отправили данные(модель OfpModel) во флоу
        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))                 //отправляем сообщение об ошибке в Flow
        }
        emit(Resource.Loading(isLoading = false))                   //завершаем загрузку установкой флага в false
    }

     // Метод для получения ID пользователя из DataStore
     //котрый был добавлен через метод addUserData
    override suspend fun getId(): Long? {
        return appDataStoreManager.readValue("userId")
    }

     // Метод для получения данных офп пользователя из БД
    override suspend fun getUserOfp(): Flow<Resource<OfpModel>> = flow {
        emit(Resource.Loading())
        try {
            val userId = appDataStoreManager.readValue("userId")        // получаем ID пользователя из DataStore
            val ofpEntity = ofpDao.getUserOfp(userId = userId!!.toInt())  // получаем данные офп по ID из БД

            Log.d(TAG, "getUserOfp5: $ofpEntity")
            emit(Resource.Success(ofpEntity.toOfpModel()))                          // отправляем в Flow модель OfpModel
            Log.d(TAG, "getUserOfp6: ${ofpEntity.toOfpModel()}")

        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))
        } finally {
            emit(Resource.Loading(isLoading = false))
        }
    }

     // Метод для получения максимального значения результата задачи "Пull Up" из БД
    override suspend fun getPullUp(): List<MonthValue> {
        Log.d(TAG, "getPullUp: ${ofpDao.maxPullUp()}")
        return ofpDao.maxPullUp()                                                   // возвращаем максимальное значение результата задачи "Пull Up" из БД
    }

     // Метод для получения информации о пользователе из БД
     override fun getUserData(): Flow<Resource<UserModel>> = flow {
         emit(Resource.Loading())
         try {
             val userId = appDataStoreManager.readValue("userId")       // получаем ID пользователя из DataStore по ключу "userId"
             val userEntity = ofpDao.getUserInfoById(id = userId!!.toInt())// получаем информацию о пользователе из БД
             Log.d(TAG, "getUserData5: $userEntity")
             emit(Resource.Success(userEntity.toUserModel()))                       // отправляем в Flow модель UserModel
             Log.d(TAG, "getUserData6: ${userEntity.toUserModel()}")
         }
         catch (ex: Exception) {
             emit(Resource.Error(message = "Error"))
         } finally {
             emit(Resource.Loading(isLoading = false))
         }
     }
 }
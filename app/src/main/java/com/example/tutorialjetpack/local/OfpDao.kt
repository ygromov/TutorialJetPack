package com.example.tutorialjetpack.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.tutorialjetpack.local.entity.UserEntity
import com.example.tutorialjetpack.local.relation.UserWithOfp

@Dao
interface OfpDao {
    // Добавление строчки данных в бд
    @Insert
    suspend fun insertOfpEntity(ofpEntity: OfpEntity)

    @Insert
    suspend fun insertUserEntity(userEntity: UserEntity)

    // Удаление строчки данных из бд
    @Delete
    suspend fun delete(ofpEntity: OfpEntity)

    // Получение всех данных из бд
    @Transaction
    @Query("SELECT * FROM userEntity where id= :id")
    suspend fun getAllOfp(id:Int): List<UserWithOfp>

    @Query("SELECT * FROM userEntity where id = :id ")
    suspend fun getUserInfoById(id: Int): UserEntity

}

// 1 - 1,Usmon, 123,12312 ,123123
// 2 - 2.Yuriy,123123,123123123,123
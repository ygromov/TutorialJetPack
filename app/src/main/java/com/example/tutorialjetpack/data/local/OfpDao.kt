package com.example.tutorialjetpack.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tutorialjetpack.data.local.entity.UserEntity
import com.example.tutorialjetpack.local.OfpEntity

@Dao
interface OfpDao {
    // Добавление строчки данных в бд
    @Insert
    suspend fun insertOfpEntity(ofpEntity: OfpEntity)

    @Insert
    suspend fun insertUserEntity(userEntity: UserEntity):Long

    // Удаление строчки данных из бд
    @Delete
    suspend fun delete(ofpEntity: OfpEntity)

    // Получение всех данных из бд
//    @Transaction
//    @Query("SELECT * FROM ofpEntity where id= :id")
//    suspend fun getAllOfp(id:Int): List<UserWithOfp>

    @Query("SELECT * FROM userEntity where id = :id ")
    suspend fun getUserInfoById(id: Int): UserEntity

//    @Transaction
    @Query("SELECT * FROM ofpEntity where userId = :userId ORDER BY id DESC LIMIT 1")
    suspend fun getUserOfp(userId: Int): OfpEntity

    //1
    //2
    //3
//    @Query("SELECT * FROM your_table_name ORDER BY id DESC LIMIT 1")
//    fun getLastAddedEntity(): YourEntity?

}

// 1 - 1,Usmon, 123,12312 ,123123
// 2 - 2.Yuriy,123123,123123123,123
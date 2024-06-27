package com.example.tutorialjetpack.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tutorialjetpack.data.local.entity.UserEntity
import com.example.tutorialjetpack.domain.model.MonthValue
import com.example.tutorialjetpack.local.OfpEntity

@Dao
interface OfpDao {

    // Добавление результатов офп(отжимания, приседы, пресс..) в бд
    @Insert
    suspend fun insertOfpEntity(ofpEntity: OfpEntity)

    //добавление юзера в бд
    @Insert
    suspend fun insertUserEntity(userEntity: UserEntity): Long

    // Удаление строчки данных из бд
    @Delete
    suspend fun delete(ofpEntity: OfpEntity)

    // Получение всех данных из бд
//    @Transaction
//    @Query("SELECT * FROM ofpEntity where id= :id")
//    suspend fun getAllOfp(id:Int): List<UserWithOfp>


    //получение данных(имя, вес, рост..) по айди
    @Query("SELECT * FROM userEntity where id = :id ")
    suspend fun getUserInfoById(id: Int): UserEntity


    //    @Transaction получение данных(количсетво отжиманий, приседа, пресс..) по айди
    @Query("SELECT * FROM ofpEntity where userId = :userId ORDER BY id DESC LIMIT 1")
    suspend fun getUserOfp(userId: Int): OfpEntity


    //получение кол-ва повторений для создания тренировки
    @Query("SELECT * FROM ofpEntity ORDER BY id DESC LIMIT 1")
    suspend fun forCreateTrain(): OfpEntity


    //получение инфы юзера(имя, рост, вес..) для создания тренировки
    @Query("SELECT * FROM userEntity ORDER BY id DESC LIMIT 1")
    suspend fun forCreateTrainUser(): UserEntity


//    SELECT strftime('%m-%Y', age.timestamp / 1000, 'unixepoch') as monthYear, maxAge, textLength
//    FROM (
//    SELECT timestamp, MAX(age) as maxAge
//    FROM messages
//    GROUP BY strftime('%m-%Y', timestamp / 1000, 'unixepoch')
//    ) as age

    //PUSH UP
    // 10 2023-06-08         2023-06-08 20
    // 20 2023 -06 -08

    // PULL UP
    // 10 2023-06-08              2023-06-08 20
    // 20 2023 -06 -08

    // Squat UP
    // 10 2023-06-08             2023-06-08 20
    // 20 2023 -06 -08

    // 2023-06-08 20 20 20


    //получение самых больших результатов в отжиманиях, приседах, прессе...
    @Query(
        """
            SELECT strftime('%m-%Y', pull.created / 1000, 'unixepoch') as created, pull.maxPull, push.maxPush, squat.maxSquat, abc.maxAbc, extens.maxExtens
            FROM (
                    SELECT created, MAX(pull) as maxPull
                    FROM ofpEntity 
                    GROUP BY strftime('%m-%Y', created / 1000, 'unixepoch')
                )as pull
                
            INNER JOIN (
             SELECT created, MAX(push) as maxPush
                    FROM ofpEntity 
                    GROUP BY strftime('%m-%Y', created / 1000, 'unixepoch')
            ) as push
            ON strftime('%m-%Y', pull.created/ 1000, 'unixepoch') = strftime('%m-%Y', push.created / 1000, 'unixepoch')
            
            INNER JOIN (
             SELECT created, MAX(squat) as maxSquat
                    FROM ofpEntity 
                    GROUP BY strftime('%m-%Y', created / 1000, 'unixepoch')
            ) as squat
             ON strftime('%m-%Y', pull.created/ 1000, 'unixepoch') = strftime('%m-%Y', squat.created / 1000, 'unixepoch')
              
            INNER JOIN (
             SELECT created, MAX(abc) as maxAbc
                    FROM ofpEntity 
                    GROUP BY strftime('%m-%Y', created / 1000, 'unixepoch')
            ) as abc
             ON strftime('%m-%Y', pull.created/ 1000, 'unixepoch') = strftime('%m-%Y', abc.created / 1000, 'unixepoch')
             
             INNER JOIN (
             SELECT created, MAX(extens) as maxExtens
                    FROM ofpEntity 
                    GROUP BY strftime('%m-%Y', created / 1000, 'unixepoch')
            ) as extens
             ON strftime('%m-%Y', pull.created/ 1000, 'unixepoch') = strftime('%m-%Y', extens.created / 1000, 'unixepoch')
              
              """
    )
    suspend fun maxPullUp(): List<MonthValue>
    //List<MonthValue>

    //1
    //2
    //3
//    @Query("SELECT * FROM your_table_name ORDER BY id DESC LIMIT 1")
//    fun getLastAddedEntity(): YourEntity?

}

// 1 - 1,Usmon, 123,12312 ,123123
// 2 - 2.Yuriy,123123,123123123,123
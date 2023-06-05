package com.example.tutorialjetpack.data.local


import androidx.room.Database

import androidx.room.RoomDatabase
import com.example.tutorialjetpack.local.OfpEntity
import com.example.tutorialjetpack.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class , OfpEntity::class],
    version = 1
)
abstract class OfpDatabase : RoomDatabase() {
    //abstract val characterDao: OfpDao

    abstract val ofpDao: OfpDao

//    companion object {
//        private var INSTANCE: OfpDatabase? = null
//
//        fun getInstance(context: Context): OfpDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    OfpDatabase::class.java,
//                    "ofp_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }

}
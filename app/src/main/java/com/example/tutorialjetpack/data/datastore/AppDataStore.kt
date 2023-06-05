package com.example.tutorialjetpack.data.datastore


interface AppDataStore {

    suspend fun setValue(
        key: String,
        value: Long
    )

    suspend fun readValue(
        key: String,
    ): Long?

}
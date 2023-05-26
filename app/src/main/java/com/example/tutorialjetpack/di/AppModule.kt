package com.example.tutorialjetpack.di

import android.app.Application
import androidx.room.Room
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.local.OfpDatabase
import com.example.tutorialjetpack.local.repositoryImpl.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): OfpDatabase {
        return Room.databaseBuilder(
            app,
            OfpDatabase::class.java,
            "ofpDB.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(
        ofpDatabase: OfpDatabase
    ): Repository {
        return RepositoryImpl(ofpDatabase.ofpDao)
    }
}
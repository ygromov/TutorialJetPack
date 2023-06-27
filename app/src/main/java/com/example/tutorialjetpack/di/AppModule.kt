package com.example.tutorialjetpack.di

import android.app.Application
import androidx.room.Room
import com.example.tutorialjetpack.data.analize.Analyze
import com.example.tutorialjetpack.data.analize.AnalyzeImpl
import com.example.tutorialjetpack.data.datastore.AppDataStore
import com.example.tutorialjetpack.data.datastore.AppDataStoreManager
import com.example.tutorialjetpack.domain.repository.Repository
import com.example.tutorialjetpack.data.local.OfpDatabase
import com.example.tutorialjetpack.data.repositoryImpl.RepositoryImpl
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
        ofpDatabase: OfpDatabase,
        appDataStoreManager: AppDataStore
    ): Repository {
        return RepositoryImpl(appDataStoreManager,ofpDatabase.ofpDao)
    }

    @Provides
    @Singleton
    fun provideAppDataStore(
        app: Application
    ): AppDataStore {
        return AppDataStoreManager(app)
    }

    @Provides
    @Singleton
    fun provideAnalyze(
        ofpDatabase: OfpDatabase
    ): Analyze {
        return AnalyzeImpl(ofpDatabase.ofpDao)
    }
}
//error commit
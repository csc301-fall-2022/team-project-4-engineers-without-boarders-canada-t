package com.example.missingseven.DI

import android.content.Context
import androidx.room.Room
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideLogDao(database: MainDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MainDatabase {
        return Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            "main.db"
        ).build()
    }
}
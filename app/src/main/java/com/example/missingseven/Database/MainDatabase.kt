package com.example.missingseven.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class MainDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
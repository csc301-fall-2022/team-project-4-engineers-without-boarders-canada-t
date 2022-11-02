package com.example.missingseven.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.Entity.TaskType

@Database(entities = [
    TaskType.ReadingTask:: class,
    TaskType.MultipleChoiceTask::class,
    TaskType.SlidingScaleTask:: class,
                     Item:: class,
                     Country::class,
                     Player::class], version = 1)
@TypeConverters(Converters::class)
abstract class MainDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
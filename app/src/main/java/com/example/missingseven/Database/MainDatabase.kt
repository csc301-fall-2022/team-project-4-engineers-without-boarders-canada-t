package com.example.missingseven.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.missingseven.Database.DAO.InstructionDao
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.InstructionType
import com.example.missingseven.Database.Entity.TaskType

@Database(entities = [TaskType.ReadingTask:: class, TaskType.MultipleChoiceTask::class, TaskType.SlidingScaleTask:: class, InstructionType.ReadingInstruction:: class], version = 1)
@TypeConverters(Converters::class)
abstract class MainDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun instructionDao(): InstructionDao
}
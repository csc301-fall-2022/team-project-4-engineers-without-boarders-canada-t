package com.example.missingseven.Database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.missingseven.Database.Entity.TaskType
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {


    @Query("SELECT * FROM readingtask")
    fun getAllReadingTasks(): Flow<List<TaskType.ReadingTask>>

    @Query("SELECT * FROM multiplechoicetask")
    fun getAllMultipleChoiceTasks(): Flow<List<TaskType.MultipleChoiceTask>>

    @Query("SELECT * FROM slidingscaletask")
    fun getAllSlidingScaleTasks(): Flow<List<TaskType.SlidingScaleTask>>

    @Insert
    suspend fun insertAllReadingTasks(tasks: List<TaskType.ReadingTask>)

    @Insert
    suspend fun insertAllMultipleChoiceTasks(tasks: List<TaskType.MultipleChoiceTask>)

    @Insert
    suspend fun insertAllSlidingScaleTasks(tasks: List<TaskType.SlidingScaleTask>)

    @Delete
    fun delete(task: TaskType.ReadingTask)

    @Query("SELECT COUNT(*) FROM readingtask")
    fun getCount(): Flow<Int>

    @Update
    suspend fun updateReadingTask(task: TaskType.ReadingTask)

    @Update
    suspend fun updateMultipleChoiceTask(task: TaskType.MultipleChoiceTask)

    @Update
    suspend fun updateSlidingScaleTasks(task: TaskType.SlidingScaleTask)
}
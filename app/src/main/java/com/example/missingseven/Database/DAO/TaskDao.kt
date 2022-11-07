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

    @Query("SELECT * FROM FilterTask")
    fun getAllFilterTasks(): Flow<List<TaskType.FilterTask>>

    @Query("SELECT * FROM shortanswertask")
    fun getAllShortAnswerTasks(): Flow<List<TaskType.ShortAnswerTask>>

    @Insert
    suspend fun insertAllReadingTasks(tasks: List<TaskType.ReadingTask>)

    @Insert
    suspend fun insertAllMultipleChoiceTasks(tasks: List<TaskType.MultipleChoiceTask>)

    @Insert
    suspend fun insertAllSlidingScaleTasks(tasks: List<TaskType.SlidingScaleTask>)

    @Insert
    suspend fun insertAllFilterTasks(tasks: List<TaskType.FilterTask>)

    @Insert
    suspend fun insertAllShortAnswerTasks(tasks: List<TaskType.ShortAnswerTask>)

    @Query("DELETE FROM readingtask")
    suspend fun deleteAllReadingTasks()

    @Query("DELETE FROM multiplechoicetask")
    suspend fun deleteAllMultipleChoiceTasks()

    @Query("DELETE FROM slidingscaletask")
    suspend fun deleteAllSlidingScaleTasks()

    @Query("DELETE FROM filtertask")
    suspend fun deleteAllFilterTasks()

    @Query("DELETE FROM shortanswertask")
    suspend fun deleteAllShortAnswerTasks()

    @Update
    suspend fun updateReadingTask(task: TaskType.ReadingTask)

    @Update
    suspend fun updateMultipleChoiceTask(task: TaskType.MultipleChoiceTask)

    @Update
    suspend fun updateSlidingScaleTasks(task: TaskType.SlidingScaleTask)

    @Update
    suspend fun updateFilterTasks(task: TaskType.FilterTask)

    @Update
    suspend fun updateShortAnswerTasks(task: TaskType.ShortAnswerTask)
}
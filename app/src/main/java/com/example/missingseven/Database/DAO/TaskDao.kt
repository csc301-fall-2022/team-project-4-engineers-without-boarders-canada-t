package com.example.missingseven.Database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.TaskType
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM readingtask")
    fun getAll(): Flow<List<TaskType.ReadingTask>>

    @Query("SELECT * FROM readingtask")
    fun getAllReadingTasks(): Flow<List<TaskType.ReadingTask>>

    @Query("SELECT * FROM multiplechoicetask")
    fun getAllMultipleChoiceTasks(): Flow<List<TaskType.MultipleChoiceTask>>

    @Query("SELECT * FROM slidingscaletask")
    fun getAllSlidingScaleTasks(): Flow<List<TaskType.SlidingScaleTask>>

    @Insert
    suspend fun insertAll(vararg tasks: TaskType.ReadingTask)

    @Delete
    fun delete(task: TaskType.ReadingTask)

    @Query("SELECT COUNT(*) FROM readingtask")
    fun getCount(): Flow<Int>
}
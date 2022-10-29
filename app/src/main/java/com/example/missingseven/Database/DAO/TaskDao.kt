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

    @Insert
    suspend fun insertAll(vararg tasks: TaskType.ReadingTask)

    @Delete
    fun delete(task: TaskType.ReadingTask)

    @Query("SELECT COUNT(*) FROM readingtask")
    fun getCount(): Flow<Int>
}
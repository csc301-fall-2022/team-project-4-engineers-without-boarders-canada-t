package com.example.missingseven.Database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM taskentity")
    fun getAll(): Flow<List<TaskEntity>>

    @Insert
    suspend fun insertAll(vararg tasks: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)

    @Query("SELECT COUNT(*) FROM taskentity")
    fun getCount(): Flow<Int>
}
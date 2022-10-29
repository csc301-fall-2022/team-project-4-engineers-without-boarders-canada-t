package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskType
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    suspend fun getReadingTasks(callback: (List<TaskType>) -> Unit){
        taskDao.getAllReadingTasks().collect {
            callback(it)
        }
    }
    suspend fun getMultipleChoiceTasks(callback: (List<TaskType>) -> Unit){
        taskDao.getAllMultipleChoiceTasks().collect {
            callback(it)
        }
    }
    suspend fun getSlidingScaleTasks(callback: (List<TaskType>) -> Unit){
        taskDao.getAllSlidingScaleTasks().collect{
            callback(it)
        }
    }
}
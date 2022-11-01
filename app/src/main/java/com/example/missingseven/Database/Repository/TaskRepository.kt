package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskType
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
        taskDao.getAllSlidingScaleTasks().collect {
            callback(it)
        }
    }
    suspend fun insertAllReadingTasks(
        tasks: List<TaskType.ReadingTask>, callback: () -> Unit){
        taskDao.insertAllReadingTasks(tasks).run {
            callback()
        }
    }

    suspend fun insertAllMultipleChoiceTasks(
        tasks: List<TaskType.MultipleChoiceTask>, callback: () -> Unit){
        taskDao.insertAllMultipleChoiceTasks(tasks).run {
            callback()
        }
    }

    suspend fun insertAllSlidingScaleTasks(
        tasks: List<TaskType.SlidingScaleTask>, callback: () -> Unit){
        taskDao.insertAllSlidingScaleTasks(tasks).run {
            callback()
        }
    }

    suspend fun updateReadingTask(
        task: TaskType.ReadingTask){
        taskDao.updateReadingTask(task)
    }

    suspend fun updateMultipleChoiceTask(
        task: TaskType.MultipleChoiceTask){
        taskDao.updateMultipleChoiceTask(task)
    }

    suspend fun updateSlidingScaleTask(
        task: TaskType.SlidingScaleTask){
        taskDao.updateSlidingScaleTasks(task)
    }
}
package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskType
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {
    suspend fun getReadingTasks(callback: (List<TaskType>) -> Unit) {
        taskDao.getAllReadingTasks().collect {
            callback(it)
        }
    }

    suspend fun getMultipleChoiceTasks(callback: (List<TaskType>) -> Unit) {
        taskDao.getAllMultipleChoiceTasks().collect {
            callback(it)
        }
    }

    suspend fun getSlidingScaleTasks(callback: (List<TaskType>) -> Unit) {
        taskDao.getAllSlidingScaleTasks().collect {
            callback(it)
        }
    }

    suspend fun getShortAnswerTasks(callback: (List<TaskType>) -> Unit) {
        taskDao.getAllShortAnswerTasks().collect { callback(it) }
    }


    suspend fun getFilterTasks(callback: (List<TaskType>) -> Unit){
        taskDao.getAllFilterTasks().collect {
            callback(it)
        }
    }

    suspend fun insertAllReadingTasks(
        tasks: List<TaskType.ReadingTask>, callback: () -> Unit
    ) {
        taskDao.insertAllReadingTasks(tasks).run {
            callback()
        }
    }

    suspend fun insertAllMultipleChoiceTasks(
        tasks: List<TaskType.MultipleChoiceTask>, callback: () -> Unit
    ) {
        taskDao.insertAllMultipleChoiceTasks(tasks).run {
            callback()
        }
    }

    suspend fun insertAllSlidingScaleTasks(
        tasks: List<TaskType.SlidingScaleTask>, callback: () -> Unit
    ) {
        taskDao.insertAllSlidingScaleTasks(tasks).run {
            callback()
        }
    }

    suspend fun insertAllFilterTasks(
        tasks: List<TaskType.FilterTask>, callback: () -> Unit
    ) {
        taskDao.insertAllFilterTasks(tasks).run {
            callback()
        }
    }

    suspend fun insertAllShortAnswerTasks(
        tasks: List<TaskType.ShortAnswerTask>, callback: () -> Unit
    ) {
        taskDao.insertAllShortAnswerTasks(tasks).run { callback() }
    }

    suspend fun updateReadingTask(
        task: TaskType.ReadingTask
    ) {
        taskDao.updateReadingTask(task)
    }

    suspend fun updateMultipleChoiceTask(
        task: TaskType.MultipleChoiceTask
    ) {
        taskDao.updateMultipleChoiceTask(task)
    }

    suspend fun updateSlidingScaleTask(
        task: TaskType.SlidingScaleTask
    ) {
        taskDao.updateSlidingScaleTasks(task)
    }

    suspend fun updateFilterTask(
        task: TaskType.FilterTask
    ) {
        taskDao.updateFilterTasks(task)
    }

    suspend fun updateShortAnswerTask(
        task: TaskType.ShortAnswerTask
    ) {
        taskDao.updateShortAnswerTasks(task)
    }

    suspend fun deleteReadingTasks(callback: () -> Unit){
        taskDao.deleteAllReadingTasks().run {
            callback()
        }
    }

    suspend fun deleteMultipleChoiceTasks(callback: () -> Unit){
        taskDao.deleteAllMultipleChoiceTasks().run {
            callback()
        }
    }

    suspend fun deleteSlidingScaleTasks(callback: () -> Unit){
        taskDao.deleteAllSlidingScaleTasks().run {
            callback()
        }
    }

    suspend fun deleteFilterTasks(callback: () -> Unit){
        taskDao.deleteAllFilterTasks().run {
            callback()
        }
    }
}
package com.example.missingseven.ViewModel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskEntity
import com.example.missingseven.Database.MainDatabase
import com.example.missingseven.Navigation.NavControl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val db: MainDatabase,
    private val taskDao: TaskDao
): ViewModel() {
    lateinit var navControl: NavControl
    var currentTaskEntity: TaskEntity? = null

    fun setupNavControl(navControl: NavControl){
        this.navControl = navControl
        initDbData()
    }


    fun initDbData(){
        viewModelScope.launch {
            if (setTasks() == 0){
                    taskDao.insertAll(TaskEntity(1, false), TaskEntity(2, false))
            }
        }
    }

    suspend fun setTasks(): Int{
        val taskDao = db.taskDao()
        val taskcount: Flow<Int> = taskDao.getCount()
        var count = 0
        taskcount.collect {
            count = it
            if (count == 0){
                taskDao.insertAll(TaskEntity(1, false), TaskEntity(2, false))
            } else {
                taskDao.getAll().collect { task ->
                    currentTaskEntity = task[0]
                }
            }
        }
        return count
    }
}
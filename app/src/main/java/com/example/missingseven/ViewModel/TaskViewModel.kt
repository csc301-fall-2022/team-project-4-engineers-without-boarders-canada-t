package com.example.missingseven.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.missingseven.Database.Entity.TaskEntity
import com.example.missingseven.Database.MainDatabase
import com.example.missingseven.Navigation.NavControl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.math.log

@HiltViewModel
class TaskViewModel: ViewModel() {
    lateinit var navControl: NavControl
    lateinit var db: MainDatabase
    var currentTaskEntity: TaskEntity? = null

    fun setupNavControl(navControl: NavControl){
        this.navControl = navControl
    }

    fun setupDB(db:MainDatabase){
        this.db = db
    }

    fun initDbData(){
        viewModelScope.launch {
            if (setTasks() == 0){
                val taskDao = db.taskDao()
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
                taskDao.getAll().collect(){ task ->
                    currentTaskEntity = task[0]
                }
            }
        }
        return count
    }
}
package com.example.missingseven.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.missingseven.DI.PrefManager
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Database.MainDatabase
import com.example.missingseven.Navigation.NavControl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val db: MainDatabase,
    private val taskDao: TaskDao,
    private val preferenceManager: PrefManager
): ViewModel() {
    lateinit var navControl: NavControl
    val currentTask: MutableState<TaskType?> = mutableStateOf(null)

    fun setupNavControl(navControl: NavControl){
        this.navControl = navControl
        initDbData()
    }


    fun initDbData(){
        viewModelScope.launch {
            if (setTasks() == 0){
//                    taskDao.insertAll(TaskEntity(1, false), TaskEntity(2, false))
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
//                taskDao.insertAll(TaskEntity(1, false), TaskEntity(2, false))
            } else {
                taskDao.getAll().collect { task ->
//                    currentTaskEntity = task[0]
                }
            }
        }
        return count
    }
}
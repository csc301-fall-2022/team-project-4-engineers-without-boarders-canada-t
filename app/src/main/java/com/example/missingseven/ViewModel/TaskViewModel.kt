package com.example.missingseven.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.missingseven.DI.PrefManager
import com.example.missingseven.Database.DAO.TaskDao
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Database.MainDatabase
import com.example.missingseven.Database.Repository.TaskRepository
import com.example.missingseven.Navigation.NavControl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository,
    private val preferenceManager: PrefManager
): ViewModel() {
    lateinit var navControl: NavControl
    val currentTask: MutableState<TaskType?> = mutableStateOf(null)
    private var taskListCount = 0
    val allFetched = mutableStateOf(false)
    private val allTasks: MutableList<TaskType> = mutableListOf()

    fun setupNavControl(navControl: NavControl){
        this.navControl = navControl
        initTasks()
    }


    private fun initTasks(){
        viewModelScope.launch {
            taskRepository.getReadingTasks {
                updateTasks(it)
            }
        }
        viewModelScope.launch {
            taskRepository.getMultipleChoiceTasks {
                updateTasks(it)
            }
        }
        viewModelScope.launch {
            taskRepository.getSlidingScaleTasks {
                updateTasks(it)
            }
        }
    }


    private fun updateTasks(list: List<TaskType>){
        allTasks.addAll(list)
        taskListCount += 1
        if (taskListCount == 3){
            allFetched.value = true
        }
    }
}
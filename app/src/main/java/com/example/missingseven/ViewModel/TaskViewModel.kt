package com.example.missingseven.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.missingseven.Database.BooleanPair
import com.example.missingseven.Database.IntPair
import com.example.missingseven.Database.PrefManager
import com.example.missingseven.Database.DataInitializer
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Database.Repository.TaskRepository
import com.example.missingseven.Model.TaskConverter
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.Navigation.NavControl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository,
    private val preferenceManager: PrefManager,
    private val dataInitializer: DataInitializer
): ViewModel() {
    lateinit var navControl: NavControl
    private val currentTaskId = mutableStateOf(-1)
    private var taskListCount = 0
    val allFetched = mutableStateOf(false)
    private val insertCompleted = MutableLiveData(0)
    private val allTasks: MutableList<TaskType> = mutableListOf()
    private val allUiStates: MutableList<TaskUiState> = mutableListOf()

    private val observer = Observer<Int> {
        if (it == TaskType.TASK_TYPE_NUM){
            preferenceManager.putBoolean(PrefManager.DATA_INITIALIZED, true)
            initTasks()
        }
    }

    fun setup(navControl: NavControl){
        this.navControl = navControl
        insertCompleted.observeForever(observer)
        if (preferenceManager.getBoolean(BooleanPair.DataInitialized)){
            insertCompleted.value = TaskType.TASK_TYPE_NUM
        } else {
            insertTasks()
        }
    }

    private fun insertTasks(){
        viewModelScope.launch {
            taskRepository.insertAllReadingTasks(dataInitializer.getAllReadingTasks()){
                insertCallback()
            }
        }
        viewModelScope.launch {
            taskRepository.insertAllMultipleChoiceTasks(dataInitializer.getAllMultipleChoiceTasks()){
                insertCallback()
            }
        }
        viewModelScope.launch {
            taskRepository.insertAllSlidingScaleTasks(dataInitializer.getAllSlidingScaleTasks()){
                insertCallback()
            }
        }
    }

    private fun insertCallback(){
        insertCompleted.value = insertCompleted.value?.plus(1)
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
        if (taskListCount == TaskType.TASK_TYPE_NUM){
            allFetched.value = true
            sortTasks(allTasks)
            setTaskUiStates()
            insertCompleted.removeObserver(observer)
            checkSharedPreference()
        }
    }

    private fun sortTasks(list: List<TaskType>): List<TaskType> {
        return list.sortedBy { it.tid }
    }

    private fun checkSharedPreference() {
        val number = preferenceManager.getInt(IntPair.CurrTask)
        if (number == -1){
            currentTaskId.value  = allTasks[0].tid
        } else {
            for (task in allTasks){
                if (task.tid == number){
                    currentTaskId.value  = task.tid
                }
            }
        }
    }

    private fun setTaskUiStates(){
        allTasks.forEach {
            TaskConverter.databaseEntityToUiState(it)?.let { task -> allUiStates.add(task) }
        }
    }

    fun getCurrentTask(): TaskUiState? {
        return if (currentTaskId.value == -1) null else allUiStates[currentTaskId.value]
    }

    fun onNextClicked(){
        currentTaskId.value += 1
    }

    fun onBackClicked(){
        currentTaskId.value -= 1
    }

    fun completeReadingHandler(){
        getCurrentTask()?.let {
            it.completed.value = true
        }
    }
}

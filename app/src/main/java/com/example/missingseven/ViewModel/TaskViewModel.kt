package com.example.missingseven.ViewModel

import android.provider.ContactsContract.Data
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
import com.example.missingseven.Database.Repository.CountryRepository
import com.example.missingseven.Database.Repository.ItemRepository
import com.example.missingseven.Database.Repository.PlayerRepository
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
    private val countryRepository: CountryRepository,
    private val itemRepository: ItemRepository,
    private val playerRepository: PlayerRepository,
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
        if (it == DataInitializer.INSERT_NUM){
            preferenceManager.putBoolean(PrefManager.DATA_INITIALIZED, true)
            initTasks()
        }
    }

    fun setup(navControl: NavControl){
        this.navControl = navControl
        insertCompleted.observeForever(observer)
        if (preferenceManager.getBoolean(BooleanPair.DataInitialized)){
            insertCompleted.value = DataInitializer.INSERT_NUM
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
        viewModelScope.launch {
            taskRepository.insertAllFilterTasks(dataInitializer.getFilterTasks()){
                insertCallback()
            }
        }
        viewModelScope.launch {
            countryRepository.insertAllCountries(dataInitializer.getAllCountries()){
                insertCallback()
            }
        }
        viewModelScope.launch {
            playerRepository.insertPlayers(dataInitializer.getAllPlayer()){
                insertCallback()
            }
        }
        viewModelScope.launch {
            itemRepository.insertAllItems(dataInitializer.getAllItem()){
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
        viewModelScope.launch {
            taskRepository.getFilterTasks {
                updateTasks(it)
            }
        }
    }


    private fun updateTasks(list: List<TaskType>){
        if (taskListCount != TaskType.TASK_TYPE_NUM){
            allTasks.addAll(list)
            taskListCount += 1
            if (taskListCount == TaskType.TASK_TYPE_NUM){
                allFetched.value = true
                allTasks.sortBy { it.tid }
                setTaskUiStates()
                insertCompleted.removeObserver(observer)
                checkSharedPreference()
            }
        }
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

    private fun putCurrTaskToSharedPreference(){
        preferenceManager.putInt(PrefManager.CURR_TASK_ID, currentTaskId.value)
    }

    private fun getCurrentTaskType(): TaskType? {
        getCurrentTask()?.let {
            return allTasks[it.tid]
        }
        return null
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
        getCurrentTask()?.let {
            if (it.completed.value){
                currentTaskId.value += 1
                putCurrTaskToSharedPreference()
            }
        }
    }

    fun isLastTask(): Boolean{
        return currentTaskId.value == allTasks.last().tid
    }

    fun isFirstTask(): Boolean {
        return currentTaskId.value == 0
    }

    fun onBackClicked(){
        currentTaskId.value -= 1
        putCurrTaskToSharedPreference()
    }

    fun completeReadingHandler(completed: Boolean){
        getCurrentTask()?.let {
            it.completed.value = completed
            getCurrentTaskType()?.let { task ->
                task.completed = completed
                viewModelScope.launch {
                    taskRepository.updateReadingTask(task as TaskType.ReadingTask)
                }
            }
        }
    }

    fun updateChooseHandler(index: Int){
        (getCurrentTask() as TaskUiState.MultipleChoiceTask).apply {
            studentAnswerIndex.value = index
            completed.value = index == correctIndex
            (getCurrentTaskType() as TaskType.MultipleChoiceTask).let { task ->
                task.studentAnswerIndex = index
                task.completed = completed.value
                viewModelScope.launch {
                    taskRepository.updateMultipleChoiceTask(task)
                }
            }
        }
    }

    fun slidingScaleTaskChangeHandler(cur: Int){
        (getCurrentTask() as TaskUiState.SlidingScaleTask).apply {
            val prevCompleted = completed.value
            current.value = cur
            completed.value = (correct - offset) <=  cur && cur <= (correct + offset)
            if (completed.value != prevCompleted){
                (getCurrentTaskType() as TaskType.SlidingScaleTask).let { task ->
                task.current = cur
                task.completed = completed.value
                viewModelScope.launch {
                    taskRepository.updateSlidingScaleTask(task) }
                }
            }
        }
    }

    fun shortAnswerTaskValueChangeHandler(value: String){
        (getCurrentTask() as TaskUiState.ShortAnswerTask).apply {
            answer.value = value
            completed.value = false
        }
    }

    fun shortAnswerSaveHandler(){
        (getCurrentTask() as TaskUiState.ShortAnswerTask).apply {
            completed.value = true
            (getCurrentTaskType() as TaskType.ShortAnswerTask).let { task ->
                task.completed = true
                viewModelScope.launch {
                    taskRepository.updateShortAnswerTask(task)
                }
            }
        }
    }
}

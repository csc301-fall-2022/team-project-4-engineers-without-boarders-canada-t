package com.example.missingseven.Model

import androidx.compose.runtime.MutableState
import com.example.missingseven.Database.Entity.TaskType

data class TaskUiState(
    val tid: Int,
    val completed: MutableState<Boolean>,
    val taskType: TaskType
)


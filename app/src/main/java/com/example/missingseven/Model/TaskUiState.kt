package com.example.missingseven.Model

import androidx.compose.runtime.MutableState

data class TaskUiState(
    val tid: Int,
    val completed: MutableState<Boolean>
)

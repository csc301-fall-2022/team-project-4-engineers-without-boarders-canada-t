package com.example.missingseven.Component

import androidx.compose.runtime.Composable
import com.example.missingseven.Model.TaskUiState

@Composable
fun MultipleChoiceTaskBody(
    task: TaskUiState.MultipleChoiceTask
) {
    task.options
}
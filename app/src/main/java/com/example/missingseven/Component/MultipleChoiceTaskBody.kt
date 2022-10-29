package com.example.missingseven.Component

import androidx.compose.runtime.Composable
import com.example.missingseven.Database.Entity.TaskType

@Composable
fun MultipleChoiceTaskBody(
    task: TaskType.MultipleChoiceTask
) {
    task.options
}
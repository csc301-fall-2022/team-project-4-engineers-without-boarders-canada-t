package com.example.missingseven.Screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.missingseven.Component.TaskTemplate
import com.example.missingseven.Database.Entity.TaskEntity
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun TaskScreen(
    viewModel: TaskViewModel,
    currentTask: TaskEntity?
){
    TaskTemplate(
        content = {
            Text(text = "Task number: ${currentTask?.let { it.tid }}")
        }
    )
}
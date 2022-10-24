package com.example.missingseven.Screen

import androidx.compose.runtime.Composable
import com.example.missingseven.Component.MultipleChoiceTaskBody
import com.example.missingseven.Component.ReadingTaskBody
import com.example.missingseven.Component.SlidingScaleTaskBody
import com.example.missingseven.Component.TaskTemplate
import com.example.missingseven.Model.TaskType
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun TaskScreen(
    viewModel: TaskViewModel
){
    TaskTemplate(
        content = {
            when (viewModel.currentTask.value){
                is TaskType.ReadingTask -> {
                    ReadingTaskBody(task = viewModel.currentTask.value as TaskType.ReadingTask)
                }
                is TaskType.MultipleChoiceTask -> {
                    MultipleChoiceTaskBody(viewModel.currentTask.value as TaskType.MultipleChoiceTask)
                }
                is TaskType.SlidingScaleTask -> {
                    SlidingScaleTaskBody(viewModel.currentTask.value as TaskType.SlidingScaleTask)
                }
                else -> {}
            }
        }
    )
}
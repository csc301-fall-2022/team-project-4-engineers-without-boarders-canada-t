package com.example.missingseven.Screen

import androidx.compose.runtime.Composable
import com.example.missingseven.Component.MultipleChoiceTaskBody
import com.example.missingseven.Component.ReadingTaskBody
import com.example.missingseven.Component.SlidingScaleTaskBody
import com.example.missingseven.Component.TaskTemplate
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun TaskScreen(
    viewModel: TaskViewModel
){
    TaskTemplate(
        content = {
            when (viewModel.getCurrentTask()){
                is TaskUiState.ReadingTask -> {
                    ReadingTaskBody({}, viewModel.getCurrentTask() as TaskUiState.ReadingTask)
                }
                is TaskUiState.MultipleChoiceTask -> {
                    MultipleChoiceTaskBody(viewModel.getCurrentTask() as TaskUiState.MultipleChoiceTask)
                }
                is TaskUiState.SlidingScaleTask -> {
                    SlidingScaleTaskBody(viewModel.getCurrentTask() as TaskUiState.SlidingScaleTask)
                }
                else -> {}
            }
        },
        nextHandler = {viewModel.onNextClicked()},
        backHandler = {viewModel.onBackClicked()},
        taskUiState = viewModel.getCurrentTask()!!
    )
}
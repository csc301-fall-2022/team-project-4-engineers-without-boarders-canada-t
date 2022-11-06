package com.example.missingseven.Screen

import androidx.compose.runtime.Composable
import com.example.missingseven.Component.*
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
                    ReadingTaskBody({completed -> viewModel.completeReadingHandler(completed)},
                        viewModel.getCurrentTask() as TaskUiState.ReadingTask)
                }
                is TaskUiState.MultipleChoiceTask -> {
                    MultipleChoiceTaskBody({index->viewModel.updateChooseHandler(index)},
                        viewModel.getCurrentTask() as TaskUiState.MultipleChoiceTask)
                }
                is TaskUiState.SlidingScaleTask -> {
                    SlidingScaleTaskBody({curr -> viewModel.slidingScaleTaskChangeHandler(curr)},
                        viewModel.getCurrentTask() as TaskUiState.SlidingScaleTask)
                }
                is TaskUiState.ShortAnswerTask -> {
                    ShortAnswerTaskBody({viewModel.shortAnswerSaveHandler()},
                        viewModel.getCurrentTask() as TaskUiState.ShortAnswerTask,
                        {value -> viewModel.shortAnswerTaskValueChangeHandler(value)})
                }
                else -> {}
            }
        },
        nextHandler = {viewModel.onNextClicked()},
        backHandler = {viewModel.onBackClicked()},
        taskUiState = viewModel.getCurrentTask()!!,
        shouldShowFirst = !viewModel.isFirstTask(),
        shouldShowLast = !viewModel.isLastTask()
    )
}
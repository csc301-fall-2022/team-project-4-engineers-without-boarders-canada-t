package com.example.missingseven.Screen

import androidx.compose.runtime.Composable
import com.example.missingseven.Component.*
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.ViewModel.FilterViewModel
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun TaskScreen(
    viewModel: TaskViewModel,
    filterViewModel: FilterViewModel
){
    TaskTemplate(
        content = {
            when (viewModel.getCurrentTask()){
                is TaskUiState.ReadingTask -> {
                    ReadingTaskBody(viewModel.getCurrentTask() as TaskUiState.ReadingTask)
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
                        {value -> viewModel.shortAnswerTaskValueChangeHandler(value)},
                        submitHandler = {context -> viewModel.submitAnswerHandler(context) }
                    )
                }
                is TaskUiState.FilterTask -> {
                    WaterFilterScreen(
                        task = viewModel.getCurrentTask() as TaskUiState.FilterTask,
                        filterViewModel = filterViewModel,
                        navControl = viewModel.navControl) {
                        viewModel.completeFilterHandler()
                    }
                }
                is TaskUiState.WelcomeTask -> {
                    WelcomeTaskBody(viewModel = viewModel)
                }
                is TaskUiState.LiteracyRateTask -> {
                    LiteracyRateTaskBody(
                        { viewModel.lRSubmitHandler() },
                        task = viewModel.getCurrentTask() as TaskUiState.LiteracyRateTask)
                }
                is TaskUiState.GlobalLiteracyRateTask -> {
                    GlobalLiteracyRateBody(
                        task = viewModel.getCurrentTask() as TaskUiState.GlobalLiteracyRateTask)
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
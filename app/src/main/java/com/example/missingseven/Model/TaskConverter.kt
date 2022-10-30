package com.example.missingseven.Model

import androidx.compose.runtime.mutableStateOf
import com.example.missingseven.Database.Entity.TaskType

class TaskConverter {

    companion object {

        fun databaseEntityToUiState(taskType: TaskType?): TaskUiState?{
            return taskType.run {
                when (this){
                    is TaskType.ReadingTask -> {
                        TaskUiState.ReadingTask(
                            tid,
                            mutableStateOf(completed),
                            header,
                            content
                        )
                    }
                    is TaskType.MultipleChoiceTask -> {
                        TaskUiState.MultipleChoiceTask(
                            tid,
                            mutableStateOf(completed),
                            header,
                            options,
                            correctIndex,
                            mutableStateOf(studentAnswerIndex)

                        )
                    }
                    is TaskType.SlidingScaleTask -> {
                        TaskUiState.SlidingScaleTask(
                            tid,
                            mutableStateOf(completed),
                            start,
                            end,
                            scale,
                            correct,
                            mutableStateOf(current)
                        )
                    }
                    else -> null
                }
            }
        }
    }
}
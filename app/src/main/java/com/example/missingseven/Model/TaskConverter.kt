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
                            content,
                            isSpecial
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
                            content,
                            start,
                            end,
                            offset,
                            unit,
                            correct,
                            mutableStateOf(current),
                            tooSmallInfo,
                            tooLargeInfo,
                            correctInfo
                        )
                    }
                    is TaskType.FilterTask -> {
                        TaskUiState.FilterTask(
                            tid,
                            mutableStateOf(completed),
                            pid
                        )
                    }
                    is TaskType.ShortAnswerTask -> {
                        TaskUiState.ShortAnswerTask(
                            tid,
                            mutableStateOf(completed),
                            question,
                            mutableStateOf(answer)
                        )
                    }
                    is TaskType.WelcomeTask -> {
                        TaskUiState.WelcomeTask(
                            tid,
                            mutableStateOf(completed),
                            "Welcome!"
                        )
                    }
                    else -> null
                }
            }
        }
    }
}
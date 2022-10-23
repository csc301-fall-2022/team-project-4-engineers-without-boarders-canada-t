package com.example.missingseven.Model

import androidx.compose.runtime.MutableState

data class TaskUiState(
    val tid: Int,
    val completed: MutableState<Boolean>,
    val taskType: TaskType
)

sealed class TaskType {
    data class ReadingTask(
        val titleResId: Int,
        val contentResId: Int
    ) : TaskType()

    data class MultipleChoiceTask(
        val questionResId: Int,
        val options: List<String>,
        val correctIndex: Int,
        var studentAnswerIndex: Int
    ) : TaskType()

    data class SlidingScaleTask(
        val questionResId: Int,
        val start: Int,
        val end: Int,
        var scale: Int,
        val correct: Int,
        var current: Int
    ): TaskType()
}

package com.example.missingseven.Model

import androidx.compose.runtime.MutableState

sealed class TaskUiState(
    open val tid: Int,
    open val completed: MutableState<Boolean>
) {
    data class ReadingTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        val header: String,
        val content: String
    ): TaskUiState(tid, completed)

    data class MultipleChoiceTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        val header: String,
        val options: List<String>,
        val correctIndex: Int,
        val studentAnswerIndex: MutableState<Int>
    ): TaskUiState(tid, completed)

    data class SlidingScaleTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        val start: Int,
        val end: Int,
        val scale: Int,
        val correct: Int,
        val current: MutableState<Int>
    ): TaskUiState(tid, completed)


}


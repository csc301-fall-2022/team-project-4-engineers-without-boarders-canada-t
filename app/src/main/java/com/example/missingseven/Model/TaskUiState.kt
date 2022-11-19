package com.example.missingseven.Model

import androidx.compose.runtime.MutableState

sealed class TaskUiState(
    open val tid: Int,
    open val completed: MutableState<Boolean>,
    open val header: String
) {
    data class ReadingTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        override val header: String,
        val content: String
    ): TaskUiState(tid, completed, header)

    data class MultipleChoiceTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        override val header: String,
        val options: List<String>,
        val correctIndex: Int,
        val studentAnswerIndex: MutableState<Int>
    ): TaskUiState(tid, completed, header)

    data class SlidingScaleTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        val content: String,
        val start: Int,
        val end: Int,
        val offset: Int,
        val unit: String,
        val correct: Int,
        val current: MutableState<Int>,
        val tooSmallInfo: String,
        val tooLargeInfo: String,
        val correctInfo: String
    ): TaskUiState(tid, completed, content)

    data class FilterTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        val pid: Int
    ): TaskUiState(tid, completed, "")

    data class ShortAnswerTask(
        override val tid: Int,
        override val completed: MutableState<Boolean>,
        val question: String,
        val answer: MutableState<String>
    ): TaskUiState(tid, completed, question)
}


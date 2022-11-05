package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class TaskType(
    open val tid: Int,
    open var completed: Boolean) {
    @Entity
    data class ReadingTask(
        @PrimaryKey override val tid: Int,
        @ColumnInfo override var completed: Boolean,
        @ColumnInfo(name = "header") val header: String,
        @ColumnInfo(name = "content") val content: String
    ) : TaskType(tid, completed)

    @Entity
    data class MultipleChoiceTask(
        @PrimaryKey override val tid: Int,
        @ColumnInfo override var completed: Boolean,
        @ColumnInfo(name = "header") val header: String,
        @ColumnInfo(name = "options")val options: List<String>,
        @ColumnInfo(name = "correctIndex")val correctIndex: Int,
        @ColumnInfo(name = "ansIndex")var studentAnswerIndex: Int
    ) : TaskType(tid, completed)

    @Entity
    data class SlidingScaleTask(
        @PrimaryKey override val tid: Int,
        @ColumnInfo override var completed: Boolean,
        @ColumnInfo(name = "content") val content: String,
        @ColumnInfo(name = "start") val start: Int,
        @ColumnInfo(name = "end") val end: Int,
        @ColumnInfo(name = "offset") var offset: Int,
        @ColumnInfo(name = "unit") val unit: String,
        @ColumnInfo(name = "correct") val correct: Int,
        @ColumnInfo(name = "current") var current: Int,
        @ColumnInfo(name = "too_small_info") val tooSmallInfo: String,
        @ColumnInfo(name = "too_large_info") val tooLargeInfo: String,
        @ColumnInfo(name = "correct_info") val correctInfo: String,
    ): TaskType(tid, completed)

    @Entity
    data class ShortAnswerTask(
        @PrimaryKey override val tid: Int,
        @ColumnInfo override var completed: Boolean,
        @ColumnInfo(name = "question") val question: String,
        @ColumnInfo(name = "answer") val answer: String
    ) : TaskType(tid, completed)

    companion object {
        const val TASK_TYPE_NUM = 4
    }
}
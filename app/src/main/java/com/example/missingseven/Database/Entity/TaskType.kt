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
        @ColumnInfo(name = "start") val start: Int,
        @ColumnInfo(name = "end") val end: Int,
        @ColumnInfo(name = "scale") var scale: Int,
        @ColumnInfo(name = "correct") val correct: Int,
        @ColumnInfo(name = "current") var current: Int
    ): TaskType(tid, completed)
}
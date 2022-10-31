package com.example.missingseven.Database

import android.content.Context
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.R

class DataInitializer constructor(
    private val context: Context
){
    fun getAllReadingTasks(): List<TaskType.ReadingTask> = listOf(
        TaskType.ReadingTask(0, false, context.getString(R.string.reading_task0_header), context.getString(R.string.reading_task0_content)),
        TaskType.ReadingTask(1, false, context.getString(R.string.reading_task1_header), context.getString(R.string.reading_task1_content))
    )

    fun getAllMultipleChoiceTasks(): List<TaskType.MultipleChoiceTask> = listOf(

    )

    fun getAllSlidingScaleTasks(): List<TaskType.SlidingScaleTask> = listOf(
        TaskType.SlidingScaleTask(
            2, false, context.getString(R.string.task2_header), 0, 8000,
            50,"M", 800, 4000,
            context.getString(R.string.tooShort),
            context.getString(R.string.tooLarge),
            context.getString(R.string.task2_correctInfo),
        )
    )
}
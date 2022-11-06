package com.example.missingseven.Database

import android.content.Context
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.R

class DataInitializer constructor(
    private val context: Context
) {
    fun getAllReadingTasks(): List<TaskType.ReadingTask> = listOf(
        TaskType.ReadingTask(
            0,
            false,
            context.getString(R.string.reading_task0_header),
            context.getString(R.string.reading_task0_content)
        ),
        TaskType.ReadingTask(
            1,
            false,
            context.getString(R.string.reading_task1_header),
            context.getString(R.string.reading_task1_content)
        )
    )

    fun getAllMultipleChoiceTasks(): List<TaskType.MultipleChoiceTask> = listOf(
        TaskType.MultipleChoiceTask(
            3, false, context.getString(R.string.mc_task2_header),
            listOf(
                context.getString(R.string.mc_task2_option0),
                context.getString(R.string.mc_task2_option1),
                context.getString(R.string.mc_task2_option2),
                context.getString(R.string.mc_task2_option3),
                context.getString(R.string.mc_task2_option4),
            ), 4, -1
        )
    )

    fun getAllSlidingScaleTasks(): List<TaskType.SlidingScaleTask> = listOf(
        TaskType.SlidingScaleTask(
            2, false, context.getString(R.string.task2_header), 0, 8000,
            50, "M", 800, 4000,
            context.getString(R.string.tooShort),
            context.getString(R.string.tooLarge),
            context.getString(R.string.task2_correctInfo),
        )
    )

    fun getFilterTasks(): List<TaskType.FilterTask> = listOf(
        TaskType.FilterTask(4, false, 0)
    )

    fun getAllCountries(): List<Country> = listOf(

    )

    fun getAllItem(): List<Item> = listOf(

    )

    fun getAllPlayer(): List<Player> = listOf(

    )


}
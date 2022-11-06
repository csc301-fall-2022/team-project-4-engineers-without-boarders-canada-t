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
    fun getAllCountries(): List<Country> = listOf(
        Country(1, "Canada", 500, "Instruction Canada"),
        Country(2, "Canadian First Nations", 500, "Instruction Canadian First Nations"),
        Country(3, "Kuwait", 400, "Instruction Kuwait"),
        Country(4, "South Africa", 65, "Instruction South Africa\""),
        Country(5, "Ghana", 40, "Instruction Ghana"),
        Country(6, "Kenya", 30, "Instruction Kenya"),
        Country(7, "Malawi", 50, "Instruction Malawi"),
    )
    fun getAllItem(): List<Item> = listOf(
        Item(1, "Rubber band", 0, 5, 1),
        Item(2, "Cheesecloth", 0, 5, 1),
        Item(3, "Cotton", 0, 5,1),
        Item(4, "Fine Sand", 0, 20, 1),
        Item(5, "Coarse Sand", 0, 20, 1),
        Item(6, "Fine Gravel", 0, 10, 1),
        Item(7, "Coarse Gravel", 0, 10, 1),
        Item(8, "Clean filter with clean water", 0, 5, 1),
    )
    fun getAllPlayer(): List<Player> = listOf(
        Player(0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1)
    )
    fun getFilterTasks(): List<TaskType.FilterTask> = listOf(
        TaskType.FilterTask(4, false, 0)
    )



}
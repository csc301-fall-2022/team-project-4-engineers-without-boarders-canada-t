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
        TaskType.ReadingTask(0, false, context.getString(R.string.reading_task0_header), context.getString(R.string.reading_task0_content)),
        TaskType.ReadingTask(1, false, context.getString(R.string.reading_task1_header), context.getString(R.string.reading_task1_content)),
        TaskType.ReadingTask(4, false, context.getString(R.string.task4_header), context.getString(R.string.task4_content))
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
            ), 4, -1),
        TaskType.MultipleChoiceTask(
            6, false, context.getString(R.string.mc_task2_header),
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
            50,"M", 800, 4000,
            context.getString(R.string.tooShort),
            context.getString(R.string.tooLarge),
            context.getString(R.string.task2_correctInfo),
        ),
        TaskType.SlidingScaleTask(
            5, false, context.getString(R.string.task5_header), 0, 8000,
            50, "M", 1000, 4000,
            context.getString(R.string.tooShort),
            context.getString(R.string.tooLarge),
            context.getString(R.string.task5_correctInfo)
        )
    )

    fun getFilterTasks(): List<TaskType.FilterTask> = listOf(
        TaskType.FilterTask(7, false, -1)
    )

    fun getShortAnswerTasks(): List<TaskType.ShortAnswerTask> = listOf(
        TaskType.ShortAnswerTask(8, false, context.getString(R.string.task8_question), ""),
        TaskType.ShortAnswerTask(9, false, context.getString(R.string.task9_question), ""),
        TaskType.ShortAnswerTask(10, false, context.getString(R.string.task10_question), ""),
        TaskType.ShortAnswerTask(11, false, context.getString(R.string.task11_question), ""),
    )

    fun getAllCountries(): List<Country> = listOf(
        Country(1, "Canada", 500, context.getString(R.string.instruction_general)),
        Country(2, "Canadian First Nations", 500, context.getString(R.string.instruction_general)),
        Country(3, "Kuwait", 400, context.getString(R.string.instruction_general)),
        Country(4, "South Africa", 65, context.getString(R.string.instruction_general)),
        Country(5, "Ghana", 40, context.getString(R.string.instruction_general)),
        Country(6, "Kenya", 30, context.getString(R.string.instruction_general)),
        Country(7, "Malawi", 50, context.getString(R.string.instruction_general)),
    )
    fun getAllItem(): List<Item> = listOf(
        Item(0, "Fine Sand", 0, 20, 3f, 4f, listOf(0.25f, 0.40f, 1.30f, 1.10f), listOf(0.5f, 0.8f, 1.3f, 1.1f)),
        Item(1, "Coarse Sand", 0, 20, 2.5f, 3f, listOf(0.3f, 0.4f, 1.2f, 1.1f), listOf(0.6f, 0.8f, 1.2f, 1.1f)),
        Item(2, "Fine Gravel", 0, 10, 2f, 2.25f, listOf(0.75f, 0.8f, 1f, 1.1f), listOf(0.75f, 0.8f, 1f, 1.1f)),
        Item(3, "Coarse Gravel", 0, 10, 1.25f, 1.3f, listOf(0.8f, 0.9f, 0.9f, 1f), listOf(0.8f, 0.9f, 0.9f, 1f)),
        Item(4, "Rubber band", 0, 5, -1f, -1f, listOf(), listOf()),
        Item(5, "Cheesecloth", 0, 5, 0.5f, 0.5f, listOf(), listOf()),
        Item(6, "Cotton", 0, 5,1f, 1f, listOf(), listOf())
    )
    fun getAllPlayer(): List<Player> = listOf(
        Player(0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, false)
    )

    companion object {
        const val INSERT_NUM = 8
    }

}
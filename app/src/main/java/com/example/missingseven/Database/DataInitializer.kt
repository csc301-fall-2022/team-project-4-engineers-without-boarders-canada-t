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
        TaskType.ReadingTask(1, true, context.getString(R.string.reading_task0_header), context.getString(R.string.reading_task0_content)),
        TaskType.ReadingTask(9, true, context.getString(R.string.task12_header),context.getString(R.string.task12_content), true)

    )

    fun getAllMultipleChoiceTasks(): List<TaskType.MultipleChoiceTask> = listOf(
        TaskType.MultipleChoiceTask(
            3, false, context.getString(R.string.task3_header),
            listOf(
                context.getString(R.string.task3_option0),
                context.getString(R.string.task3_option1),
                context.getString(R.string.task3_option2),
                context.getString(R.string.task3_option3),
                context.getString(R.string.task3_option4),
            ), 4, -1, context.getString(R.string.task3_popup)),
        TaskType.MultipleChoiceTask(
            7, false, context.getString(R.string.task3_header),
            listOf(
                context.getString(R.string.task7_option0),
                context.getString(R.string.task7_option1),
                context.getString(R.string.task7_option2),
                context.getString(R.string.task7_option3),
                context.getString(R.string.task7_option4),
            ), 4, -1, context.getString(R.string.task7_popup)
        )
    )

    fun getAllSlidingScaleTasks(): List<TaskType.SlidingScaleTask> = listOf(
        TaskType.SlidingScaleTask(
            tid = 2,
            completed = false,
            content = context.getString(R.string.task2_header),
            subtitle = context.getString(R.string.task2_subtitle),
            start = 0,
            end = 8000,
            offset = 50,
            unit = "M",
            correct = 800,
            current = 4000,
            tooSmallInfo = context.getString(R.string.tooShort),
            tooLargeInfo = context.getString(R.string.tooLarge),
            correctInfo = context.getString(R.string.task2_correctInfo),
        ),
        TaskType.SlidingScaleTask(
            tid = 6,
            completed = false,
            content = context.getString(R.string.task6_header),
            subtitle = context.getString(R.string.task6_subtitle),
            start = 0,
            end = 8000,
            offset = 50,
            unit = "M",
            correct = 1000,
            current = 4000,
            tooSmallInfo = context.getString(R.string.tooShort),
            tooLargeInfo = context.getString(R.string.tooLarge),
            correctInfo = context.getString(R.string.task6_correctInfo)
        )
    )

    fun getFilterTasks(): List<TaskType.FilterTask> = listOf(
        TaskType.FilterTask(99, false, -1)
    )

    fun getWelcomeTask(): List<TaskType.WelcomeTask> = listOf(
        TaskType.WelcomeTask(0, true)
    )

    fun getLiteracyRateTasks(): List<TaskType.LiteracyRateTask> = listOf(
        TaskType.LiteracyRateTask(
            4, true, "The literacy rate is defined by the percentage of the population of a given age group that can read and write.", 99F, 99F, 79.04F, 81.54F, 96.46F, 62.14F, 95.02F,
            "", "Yes, literacy rates are lowest in the Sub-Saharan African countries."
        )
    )

    fun getGLRTasks(): List<TaskType.GlobalLiteracyRateTask> = listOf(
        TaskType.GlobalLiteracyRateTask(
            5, true,
            "Global Literacy Rate",
            "The literacy rate is defined by the percentage of the population of " +
                    "a given age group that can read and write.",
            "Our World in Data",
            "ourworldindata.org/"
        ),
        TaskType.GlobalLiteracyRateTask(
            8, true,
            "Global Extreme Poverty",
            context.getString(R.string.task_8_content),
            "Our World in Data",
            "ourworldindata.org/"
        )

    )

    fun getShortAnswerTasks(): List<TaskType.ShortAnswerTask> = listOf(
        TaskType.ShortAnswerTask(10, false, context.getString(R.string.task8_question), ""),
        TaskType.ShortAnswerTask(11, false, context.getString(R.string.task9_question), ""),
        TaskType.ShortAnswerTask(12, false, context.getString(R.string.task10_question), ""),
        TaskType.ShortAnswerTask(13, false, context.getString(R.string.task11_question), "", true),
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
        Item(0, "Fine Sand", 0, 20, 3f, 4f, listOf(0.25f, 0.40f, 1.30f, 1.10f,1f,1f), listOf(0.5f, 0.8f, 1.3f, 1.1f,1f,1f)),
        Item(1, "Coarse Sand", 0, 20, 2.5f, 3f, listOf(0.3f, 0.4f, 1.2f, 1.1f,1f,1f), listOf(0.6f, 0.8f, 1.2f, 1.1f,1f,1f)),
        Item(2, "Fine Gravel", 0, 10, 2f, 2.25f, listOf(0.75f, 0.8f, 1f, 1.1f,1f,1f), listOf(0.75f, 0.8f, 1f, 1.1f,1f,1f)),
        Item(3, "Coarse Gravel", 0, 10, 1.25f, 1.3f, listOf(0.8f, 0.9f, 0.9f, 1f,1f,1f), listOf(0.8f, 0.9f, 0.9f, 1f,1f,1f)),
        Item(4, "Cheesecloth", 0, 5, 0.5f, 0.5f, listOf(), listOf()),
        Item(5, "Cotton", 0, 5,1f, 1f, listOf(), listOf()),
        Item(6, "Rubber band", 0, 5, -1f, -1f, listOf(), listOf()),
    )
    fun getAllPlayer(): List<Player> = listOf(
        Player(0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,false)
    )

    companion object {
        const val INSERT_NUM = 11
    }

}
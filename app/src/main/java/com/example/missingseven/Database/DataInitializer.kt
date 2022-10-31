package com.example.missingseven.Database

import android.content.Context
import com.example.missingseven.Database.Entity.*
import com.example.missingseven.R

class DataInitializer constructor(
    private val context: Context
){
    fun getAllReadingTasks(): List<TaskType.ReadingTask> = listOf(
        TaskType.ReadingTask(0, false, context.getString(R.string.reading_task0_header), context.getString(R.string.reading_task0_content)),
        TaskType.ReadingTask(1, false, context.getString(R.string.reading_task1_header), context.getString(R.string.reading_task1_content))
    )

    fun getAllReadingInstructions(): List<InstructionType.ReadingInstruction> = listOf(
        InstructionType.ReadingInstruction(0, false, context.getString(R.string.reading_instruction_header), context.getString(R.string.reading_instruction0_content)),
        InstructionType.ReadingInstruction(1, false, context.getString(R.string.reading_instruction_header), context.getString(R.string.reading_instruction1_content)),
        InstructionType.ReadingInstruction(2, false, context.getString(R.string.reading_instruction_header), context.getString(R.string.reading_instruction2_content)),
        InstructionType.ReadingInstruction(3, false, context.getString(R.string.reading_instruction_header), context.getString(R.string.reading_instruction3_content))
    )

    fun getAllMultipleChoiceTasks(): List<TaskType.MultipleChoiceTask> = listOf(

    )

    fun getAllSlidingScaleTasks(): List<TaskType.SlidingScaleTask> = listOf(

    )

    fun getAllCountries(): List<CountryType.Country> = listOf(

    )

    fun getAllItem(): List<ItemType.Item> = listOf(

    )

    fun getAllPlayer(): List<PlayerType.Player> = listOf(

    )


}
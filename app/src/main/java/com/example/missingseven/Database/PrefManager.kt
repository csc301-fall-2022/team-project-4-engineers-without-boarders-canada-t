package com.example.missingseven.Database

import android.content.SharedPreferences
import javax.inject.Inject

class PrefManager @Inject constructor(
    private val preferences: SharedPreferences
){
    private val editor = preferences.edit()

    fun getInt(pair: IntPair) = preferences.getInt(pair.key, pair.default)

    fun putInt(key: String, value: Int){
        editor.putInt(key, value).apply()
    }

    fun getBoolean(pair: BooleanPair) = preferences.getBoolean(pair.key, pair.default)

    fun putBoolean(key: String, value: Boolean){
        editor.putBoolean(key, value).apply()
    }

    companion object {
        const val CURR_TASK_ID = "FLAG_CURR_TASK_ID"
        const val DATA_INITIALIZED = "FLAG_DATA_INITIALIZED"
        const val CURR_INSTRUCTION_ID = "FLAG_CURR_INSTRUCTION_ID"
        const val DATA_INITIALIZED_INSTRUCTION = "FLAG_DATA_INITIALIZED_INSTRUCTION"
    }
}

sealed class IntPair(
    val key: String,
    val default: Int
) {
    object CurrTask: IntPair(PrefManager.CURR_TASK_ID, -1)
    object CurrInstruction: IntPair(PrefManager.CURR_INSTRUCTION_ID, -1)
}

sealed class BooleanPair(
    val key: String,
    val default: Boolean
) {
    object DataInitialized: BooleanPair(PrefManager.DATA_INITIALIZED, false)
    object DataInitializedInstruction: BooleanPair(PrefManager.DATA_INITIALIZED_INSTRUCTION, false)
}
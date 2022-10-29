package com.example.missingseven.DI

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
    companion object {
        const val CURR_TASK_ID = "FLAG_CURR_TASK_ID"
    }
}

sealed class IntPair(
    val key: String,
    val default: Int
) {
    object CurrTask: IntPair(PrefManager.CURR_TASK_ID, -1)
}
package com.example.missingseven.DI

import android.content.SharedPreferences
import javax.inject.Inject

class PrefManager @Inject constructor(
    private val preferences: SharedPreferences
){
    private val editor = preferences.edit()

    fun getInt(key: String) = preferences.getInt(key, -1)

    fun putInt(key: String, value: Int){
        editor.putInt(key, value).apply()
    }
}
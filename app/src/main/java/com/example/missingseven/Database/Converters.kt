package com.example.missingseven.Database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: List<String>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun floatListToJson(value: List<Float>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToFloatList(value: String) = Gson().fromJson(value, Array<Float>::class.java).toList()
}
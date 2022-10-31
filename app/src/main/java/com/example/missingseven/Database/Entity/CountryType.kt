package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

sealed class CountryType(
    open val cid: Int,
    open val name: String,
    open val money: Int,
    open val instruction: String
) {
    data class Country(
        @PrimaryKey override val cid: Int,
        @ColumnInfo override val name: String,
        @ColumnInfo override val money: Int,
        @ColumnInfo override val instruction: String
    ) : CountryType(cid, name, money, instruction)

    companion object {
        const val COUNTRY_TYPE_NUM = 6
    }

}
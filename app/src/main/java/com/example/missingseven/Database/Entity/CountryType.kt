package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryType(
    @PrimaryKey val cid: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val money: Int,
    @ColumnInfo val instruction: String
)
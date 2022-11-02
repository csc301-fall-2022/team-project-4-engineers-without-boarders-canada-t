package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Player(
    @PrimaryKey val pid: Int,
    @ColumnInfo val cid: Int,
    @ColumnInfo var curr_money: Int
)
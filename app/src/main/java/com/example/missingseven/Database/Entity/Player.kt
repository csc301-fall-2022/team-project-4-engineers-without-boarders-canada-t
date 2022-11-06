package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Player(
    @PrimaryKey val pid: Int,
    @ColumnInfo var cid: Int,
    @ColumnInfo var curr_money: Int,
    @ColumnInfo var layer0: Int,
    @ColumnInfo var layer1: Int,
    @ColumnInfo var layer2: Int,
    @ColumnInfo var layer3: Int,
    @ColumnInfo var layer4: Int,
    @ColumnInfo var layer5: Int,
    @ColumnInfo var layer6: Int,
    @ColumnInfo var layer7: Int
){
    fun updatePlayerByIndex(index: Int, value: Int){
        when (index){
            0 -> layer0 = value
            1 -> layer1 = value
            2 -> layer2 = value
            3 -> layer3 = value
            4 -> layer4 = value
            5 -> layer5 = value
            6 -> layer6 = value
            7 -> layer7 = value
        }
    }
}
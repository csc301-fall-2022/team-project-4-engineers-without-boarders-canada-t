package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class PlayerType(
    open val pid: Int,
    open val cid: Int,
    open var curr_money: Int){
    @Entity
    data class Player(
        @PrimaryKey override val pid: Int,
        @ColumnInfo override val cid: Int,
        @ColumnInfo override var curr_money: Int
    ) : PlayerType(pid, cid, curr_money)

    companion object {
        const val PLAYER_TYPE_NUM = 4
    }
}
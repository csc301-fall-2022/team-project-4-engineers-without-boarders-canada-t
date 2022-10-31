package com.example.missingseven.Model

sealed class PlayerUiState(

    open val pid: Int,
    open val cid: Int,
    open var curr_money: Int){
    data class Player(
        override val pid: Int,
        override val cid: Int,
        override var curr_money: Int
    ): PlayerUiState(pid, cid, curr_money)

}
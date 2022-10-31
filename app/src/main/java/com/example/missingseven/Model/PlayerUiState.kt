package com.example.missingseven.Model

data class PlayerUiState(
    val pid: Int,
    val cid: Int,
    var currMoney: Int,
    val countryName: String,
    val instruction: String
)
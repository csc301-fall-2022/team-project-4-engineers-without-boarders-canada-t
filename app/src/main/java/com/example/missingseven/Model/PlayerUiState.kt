package com.example.missingseven.Model

import androidx.compose.runtime.MutableState


data class PlayerUiState(
    val pid: Int,
    val cid: Int,
    var currMoney: Int,
    val countryName: String,
    val instruction: String
) {
    fun getLayerValueByIndex(index: Int): MutableState<Int>{

    }
}
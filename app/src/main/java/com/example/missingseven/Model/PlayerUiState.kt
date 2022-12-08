package com.example.missingseven.Model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import com.example.missingseven.Database.Entity.Player

/***
 * data class of the ui model for [Player]
 */
data class PlayerUiState(
    val pid: Int,
    val cid: Int,
    var currMoney: MutableState<Int>,
    val countryName: String,
    val instruction: String,
    val neck: MutableState<Int>,
    val mouth: MutableState<Int>,
    val layer0: MutableState<Int>,
    val layer1: MutableState<Int>,
    val layer2: MutableState<Int>,
    val layer3: MutableState<Int>,
    val layer4: MutableState<Int>,
    val layer5: MutableState<Int>,
    val layer6: MutableState<Int>,
    val layer7: MutableState<Int>,
    var neckRubberBanded: Boolean
){
    fun getLayerValueByIndex(index: Int): MutableState<Int>{
        return when (index){
            0 -> layer0
            1 -> layer1
            2 -> layer2
            3 -> layer3
            4 -> layer4
            5 -> layer5
            6 -> layer6
            7 -> layer7
            else -> mutableStateOf(-1)
        }
    }

}
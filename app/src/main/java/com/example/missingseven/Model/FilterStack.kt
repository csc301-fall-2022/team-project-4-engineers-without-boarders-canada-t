package com.example.missingseven.Model

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

class FilterStack(
    val itemList: MutableList<ItemUiState?>,
    val topIndex: MutableState<Int>
) {
    fun isFull(): Boolean {

    }

    fun add(item: ItemUiState){

    }

    fun displayedStack(): List<ItemUiState?>{

    }

    fun getBoarderColor(reversedIndex: Int): Color {

    }

    companion object {
        const val MAX_LAYER = 8
    }
}
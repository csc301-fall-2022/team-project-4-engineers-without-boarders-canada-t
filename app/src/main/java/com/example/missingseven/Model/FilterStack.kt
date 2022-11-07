package com.example.missingseven.Model

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

class FilterStack(
    val itemList: MutableList<ItemUiState?>,
    val topIndex: MutableState<Int>
) {
    fun isFull() = topIndex.value == MAX_LAYER

    fun add(item: ItemUiState){
        itemList[topIndex.value] = item
        topIndex.value += 1
    }

    fun displayedStack(): MutableList<ItemUiState?>{
        return itemList.reversed() as MutableList<ItemUiState?>
    }

    fun getBoarderColor(reversedIndex: Int): Color {
        val index = MAX_LAYER - 1 - reversedIndex
        return if (index < topIndex.value){
            Color.Red
        } else if (index == topIndex.value){
            Color.Green
        } else {
            Color.Black
        }
    }

    companion object {
        const val MAX_LAYER = 8
    }
}
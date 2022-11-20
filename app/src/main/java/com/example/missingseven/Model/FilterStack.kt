package com.example.missingseven.Model

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

class FilterStack(
    val itemList: MutableList<ItemUiState?>,
    val topIndex: MutableState<Int>,
    val neck: MutableState<ItemUiState?>,
    var neckRubberBanded: Boolean,
    var cleaned: Boolean = false
) {
    fun isFull() = topIndex.value == MAX_LAYER

    fun add(item: ItemUiState){
        if (neck.value == null){
            if (item.isRubberBand()){
                neckRubberBanded = true
            } else {
                neck.value = item
            }
        } else {
            if (!item.isRubberBand()){
                itemList[topIndex.value] = item
                topIndex.value += 1
            }
        }
    }

    fun displayedStack(): MutableList<ItemUiState?>{
        return itemList.reversed() as MutableList<ItemUiState?>
    }

    fun getBoarderColor(reversedIndex: Int): Color {
        val index = MAX_LAYER - 1 - reversedIndex
        return if (neck.value == null){
            Color.Black
        } else if (index < topIndex.value){
            Color.Red
        } else if (index == topIndex.value){
            Color.Green
        } else {
            Color.Black
        }
    }

    fun getNeckColor() = if (neck.value == null){
        Color.Green
    } else {
        Color.Red
    }

    companion object {
        const val MAX_LAYER = 8
    }
}
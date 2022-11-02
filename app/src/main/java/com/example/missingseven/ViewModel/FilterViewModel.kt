package com.example.missingseven.ViewModel

import androidx.lifecycle.ViewModel
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Model.ItemUiState
import com.example.missingseven.Model.PlayerUiState
import com.example.missingseven.R
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
) : ViewModel() {

    var itemList = mutableListOf<ItemUiState>()
    var playerUiState :PlayerUiState?= null

    // map for index and item stored in the water filter
    val indexItemMap: Map<Int, ItemUiState?> = mapOf()

    // map for shop selected item(Iid) and selected count
    val shopIidCountMap: Map<Int, Int> = mapOf()

    // all maps, key: Iid, Value: ItemUiState
    val allIIdItemsMap: Map<Int, ItemUiState> = mapOf()

    // TODO replace with FilterTask when ready
    fun setup(task: TaskType){

    }

    fun add(cid: Int){

    }

    fun sub(cid: Int){

    }

    fun checkout(){
        // TODO update count in allIidItemMap subtract money, reset all values in shopMap to 0
    }

}
package com.example.missingseven.ViewModel

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Model.ItemUiState
import com.example.missingseven.Model.PlayerUiState
import com.example.missingseven.Navigation.ParamSet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
) : ViewModel() {

    var itemList = mutableListOf<ItemUiState>()
    var playerUiState :PlayerUiState?= null

    // map for index and item stored in the water filter
    val indexItemMap: Map<Int, ItemUiState?> = mutableMapOf()

    // map for shop selected item(Iid) and selected count
    private val shopIidCountMap: Map<Int, Int> = mutableMapOf()

    // all maps, key: Iid, Value: ItemUiState
    private val allIIdItemsMap: Map<Int, ItemUiState> = mutableMapOf()

    // TODO replace with FilterTask when ready
    fun setup(task: TaskType){

    }

    fun add(iid: Int){
        shopIidCountMap[iid]?.let{
            shopIidCountMap.put(iid, it.plus(1))
        }
        }

    fun sub(iid: Int){
        if (shopIidCountMap[iid]!! >0) {
            shopIidCountMap[iid]?.let{
                shopIidCountMap.put(iid, it.minus(1))
        }
    }}

    fun checkout(): Int{
        // TODO update count in allIidItemMap subtract money, reset all values in shopMap to 0
        var money: Int = 0
        for ((iid, item) in allIIdItemsMap) {
            money += (allIIdItemsMap[iid]?.price ?: 0) * shopIidCountMap[iid]!!
            allIIdItemsMap[iid]?.quantity.let{
                allIIdItemsMap[iid]?.quantity?  += shopIidCountMap[iid]!!
            }
            shopIidCountMap.put(iid, 0)
        }
        return money
    }

}
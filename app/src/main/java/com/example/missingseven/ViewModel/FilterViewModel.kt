package com.example.missingseven.ViewModel

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Database.Repository.CountryRepository
import com.example.missingseven.Database.Repository.ItemRepository
import com.example.missingseven.Database.Repository.PlayerRepository
import com.example.missingseven.Model.ItemUiState
import com.example.missingseven.Model.PlayerUiState
import com.example.missingseven.Navigation.ParamSet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.missingseven.Model.FilterStack
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.Navigation.NavControl
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class FilterViewModel @Inject constructor(
    val playerRepository: PlayerRepository,
    val countryRepository: CountryRepository,
    val itemRepository: ItemRepository
) : ViewModel() {
    //FilterTask which stores the current task
    lateinit var filterTask: TaskUiState.FilterTask

    //FilterStack which stores the filter stack
    lateinit var filterStack: FilterStack

    // current player
    lateinit var player: Player

    //the list of all countries
    lateinit var countries: List<Country>

    //store the playerUiState
    lateinit var playerUiState: PlayerUiState

    //store the navigation controller
    lateinit var navControl: NavControl

    //indicate whether setup tasks are completed
    val setupCompleted: MutableState<Boolean> = mutableStateOf(false)

    // store the key-value pair of (Iid, Count) for each item in the shop
    // count means how many items are selected in the shop
    private val shopIidCountMap: MutableMap<Int, MutableState<Int>> = mutableMapOf()

    // store all items by the key-value pair of the items iid and the ItemUiState
    private val allIIdItemsMap: Map<Int, ItemUiState> = mutableMapOf()

    fun setup(control: NavControl, filter:TaskUiState.FilterTask,stack: FilterStack,
    country: List<Country>,playerUiState: PlayerUiState){
        navControl = control
        filterTask = filter
        filterStack = stack
        countries = country
        this.playerUiState = playerUiState

        fun fetchPlayer(){
            val allPlayer = viewModelScope.launch{
                PlayerRepository.getPlayers()}
                this.player = allPlayer[0]
            }
        }
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
                allIIdItemsMap[iid]?.quantity? += shopIidCountMap[iid]!!
            }
            shopIidCountMap.put(iid, 0)
        }
        return money
    }

}
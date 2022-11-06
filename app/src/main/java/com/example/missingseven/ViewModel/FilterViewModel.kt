package com.example.missingseven.ViewModel

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Database.Repository.CountryRepository
import com.example.missingseven.Database.Repository.ItemRepository
import com.example.missingseven.Database.Repository.PlayerRepository
import com.example.missingseven.Navigation.ParamSet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.missingseven.Navigation.NavControl
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.Model.*
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
    private val allIIdItemsMap: MutableMap<Int, ItemUiState> = mutableMapOf()

    fun setup(control: NavControl, filter:TaskUiState.FilterTask){
        navControl = control
        filterTask = filter
        fetchPlayer()
    }

    fun fetchPlayer(){
        viewModelScope.launch{
            val allPlayer = playerRepository.getPlayers {
                player = it[0]
                fetchCountries()
            }
        }
    }

    private fun fetchCountries(){
        viewModelScope.launch{
            countryRepository.getAllCountries {
                countries = it
                if (player.cid == -1){
                    viewModelScope.launch{
                        val random = countries.random()
                        player.cid = random.cid
                        player.curr_money = random.money
                        viewModelScope.launch {
                            playerRepository.updatePlayer(player)
                        }
                    }
                }
                fetchItems()
            }
        }

    }

    private fun fetchItems() {
        viewModelScope.launch {
            itemRepository.getItems {
                for (item in it) {
                    shopIidCountMap[item.iid] = mutableStateOf(0)
                    allIIdItemsMap[item.iid] = ItemConverter.databaseEntityToUiState(item)
                }
            }
        }
        setupPlayerUiState()
        setupStack()
    }

    private fun setupPlayerUiState(){
        // TODO replace by get playerCountry
        PlayerConverter.databaseEntityToUiState(player,
            countries[player.cid].name, countries[player.cid].instruction)
    }

    private fun setupStack(){
        val itemList = mutableListOf<ItemUiState?>()
        var currTop = 0
        for (i in 0 until FilterStack.MAX_LAYER){
            if (playerUiState.getLayerValueByIndex(i).value != -1){
                itemList.add(allIIdItemsMap[playerUiState.getLayerValueByIndex(i).value])
                currTop += 1
            } else {
                itemList.add(null)
            }
        }
        filterStack = FilterStack(itemList, mutableStateOf(currTop))
        setupCompleted.value = true
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
package com.example.missingseven.ViewModel

import androidx.lifecycle.ViewModel
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.Repository.CountryRepository
import com.example.missingseven.Database.Repository.ItemRepository
import com.example.missingseven.Database.Repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.missingseven.Navigation.NavControl
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.missingseven.Model.*
import com.example.missingseven.Navigation.Screen
import kotlinx.coroutines.launch

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val playerRepository: PlayerRepository,
    private val countryRepository: CountryRepository,
    private val itemRepository: ItemRepository
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
    val shopIidCountMap: MutableMap<Int, MutableState<Int>> = mutableMapOf()

    // store all items by the key-value pair of the items iid and the ItemUiState
    val allIIdItemsMap: MutableMap<Int, ItemUiState> = mutableMapOf()

    lateinit var items: List<ItemUiState>

    private val fetchCount = mutableStateOf(0)

    fun setup(control: NavControl, filter:TaskUiState.FilterTask){
        setupCompleted.value = false
        fetchCount.value = 0
        navControl = control
        filterTask = filter
        fetchPlayer()
        fetchCountries()
        fetchItems()
    }

    fun fetchPlayer(){
        viewModelScope.launch{
            playerRepository.getPlayers {
                player = it[0]
                fetchCallback()
            }
        }
    }

    fun fetchCompleted() = fetchCount.value == 3

    private fun fetchCallback(){
        if (!fetchCompleted()){
            fetchCount.value += 1
        }
    }

    fun getParallelCountryList(): Pair<List<Country>, List<Country>>{
        return Pair(countries.filter { it.cid < 4 }, countries.filter { it.cid >= 4 })
    }

    fun fetchCountries(){
        viewModelScope.launch{
            countryRepository.getAllCountries {
                countries = it
                fetchCallback()
//                if (player.cid == -1){
//                    viewModelScope.launch{
//                        val random = countries.random()
//                        player.cid = random.cid
//                        player.curr_money = random.money
//                        viewModelScope.launch {
//                            playerRepository.updatePlayer(player)
//                        }
//                    }
//                }
//                fetchItems()
            }
        }

    }

    fun fetchItems() {
        viewModelScope.launch {
            itemRepository.getItems { it ->
                for (item in it) {
                    shopIidCountMap[item.iid] = mutableStateOf(0)
                    allIIdItemsMap[item.iid] = ItemConverter.databaseEntityToUiState(item)
                }
                items = it.map { item -> ItemConverter.databaseEntityToUiState(item) }
                fetchCallback()
//                setupPlayerUiState()
//                setupStack()
            }
        }
    }

    fun setupPlayerUiState(){
        getPlayerCountry()?.let {
            playerUiState = PlayerConverter.databaseEntityToUiState(player, it.name, it.instruction)
        }
    }

    fun setupStack(){
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
        filterStack = FilterStack(
            itemList,
            mutableStateOf(currTop),
            neck = mutableStateOf(allIIdItemsMap[playerUiState.neck.value]),
            mouth = mutableStateOf(allIIdItemsMap[playerUiState.mouth.value]), // place holder for value of mouth
            playerUiState.neckRubberBanded,
        )

        setupCompleted.value = true
    }

    fun countrySelect(country: Country){
        player.cid = country.cid
        player.curr_money = country.money
        viewModelScope.launch {
            playerRepository.updatePlayer(player)
        }
        setupPlayerUiState()
        setupStack()
        navControl.navigate(Screen.Task.route, Screen.Filter.route)
    }

    fun getInstruction(): String{
        return playerUiState.instruction
    }

    fun openInstruction(){
        navControl.navigate(Screen.Filter.route, Screen.Instruction.route)
    }

    fun navigateBack(){
        navControl.navigateBack()
    }


    fun onStackClicked(){
        if (!filterStack.isFull() && !filterTask.completed.value){
            navControl.navigate(Screen.Filter.route, Screen.ItemSelect.route)
        }
    }

    fun getSelectableItemList(): List<ItemUiState>{
        val result = mutableListOf<ItemUiState>()
        for (item in allIIdItemsMap.values) {
            if (item.quantity > 0){
                result.add(item)
            }
        }
        return result
    }

    fun selectItem(item: ItemUiState){
        filterStack.add(item)
        player.updatePlayerByIndex(filterStack.topIndex.value - 1, item.iid)
        allIIdItemsMap[item.iid]?.apply {
            quantity -= 1
            viewModelScope.launch {
                itemRepository.updateItem(ItemConverter.UiStateToDatabaseEntity(this@apply))
            }
            viewModelScope.launch {
                playerRepository.updatePlayer(player)
            }
        }
//        navControl.navigateBack()
    }

    fun getPlayerCountry(): Country?{
        for (country in countries) {
            if (player.cid == country.cid){
                return country
            }
        }
        return null
    }

    fun shopClicked(){
        navControl.navigate(Screen.Filter.route, Screen.Shop.route)
    }

    fun add(iid: Int){
        shopIidCountMap[iid]?.let{
            it.value += 1
        }
    }

    fun sub(iid: Int){
        shopIidCountMap[iid]?.let{
            if (it.value > 0){
                it.value -= 1
            }
        }
    }

    fun checkout(){
        playerUiState.currMoney.value -= totalPrice()
        for ((iid) in allIIdItemsMap) {
            allIIdItemsMap[iid]?.let{
                it.quantity += shopIidCountMap[iid]!!.value
                viewModelScope.launch {
                    itemRepository.updateItem(ItemConverter.UiStateToDatabaseEntity(it))
                }
            }
            shopIidCountMap[iid]!!.value = 0
        }
        player.curr_money = playerUiState.currMoney.value
        viewModelScope.launch {
            playerRepository.updatePlayer(player)
        }
        navControl.navigateBack()
    }

    fun playerScore(): Int {
        var score = 0
        filterStack.itemList.forEach {
            it?.let { item ->
                score += 0
            }
        }
        return score
    }

    fun checkoutAble() = totalPrice() <= player.curr_money

    fun totalPrice(): Int {
        var total = 0
        shopIidCountMap.forEach {
            allIIdItemsMap[it.key]?.let { item ->
                total += item.price * it.value.value
            }
        }
        return total
    }


}
package com.example.missingseven

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import com.example.missingseven.Database.DAO.CountryDAO
import com.example.missingseven.Database.DAO.ItemDAO
import com.example.missingseven.Database.DAO.PlayerDAO
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.IntPair
import com.example.missingseven.Database.PrefManager
import com.example.missingseven.Database.Repository.CountryRepository
import com.example.missingseven.Database.Repository.ItemRepository
import com.example.missingseven.Database.Repository.PlayerRepository
import com.example.missingseven.Database.Repository.TaskRepository
import com.example.missingseven.Model.ItemConverter
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.Navigation.NavControl
import com.example.missingseven.Navigation.Screen
import com.example.missingseven.ViewModel.FilterViewModel
import com.example.missingseven.ViewModel.TaskViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val playerDAO: PlayerDAO = mock()
    private val countryDAO: CountryDAO = mock()
    private val itemDAO: ItemDAO = mock()

    private val prefManager: PrefManager = mock()
    private val playerRepository = PlayerRepository(prefManager, playerDAO)
    private val countryRepository = CountryRepository(countryDAO, prefManager)
    private val itemRepository = ItemRepository(prefManager, itemDAO)

    private lateinit var viewModel: FilterViewModel
    val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup(){
        viewModel = FilterViewModel(
            playerRepository,
            countryRepository,
            itemRepository
        )
        Dispatchers.setMain(dispatcher)
        whenever(prefManager.getInt(IntPair.CurrTask)).thenReturn(1)
    }


    @Test
    fun testFilterViewModelSetup() = runBlocking {
        val player1 = Player(2, 222, 100, 11, 22, 33,
            44, 55, 66,77, 88)

        whenever(playerDAO.getAllPlayers()).thenReturn(
            flow {
                emit(listOf(player1))
            }
        )
        val control = NavControl(mock())
        val filter = TaskUiState.FilterTask(1, mutableStateOf(true),111)

        viewModel.setup(control, filter)

        assertEquals(control, viewModel.navControl)
        assertEquals(filter, viewModel.filterTask)
        assertEquals(viewModel.filterTask.tid, 1)
        assertEquals(viewModel.filterTask.completed.value, true)
        assertEquals(viewModel.filterTask.pid, 111)
    }

    @Test
    fun testFetchPlayer() = runBlocking{
        val player1 = Player(2, 222, 100, 11, 22, 33,
            44, 55, 66,77, 88)

        whenever(playerDAO.getAllPlayers()).thenReturn(
            flow {
                emit(listOf(player1))
            }
        )
        val control = NavControl(mock())
        val filter = TaskUiState.FilterTask(1, mutableStateOf(true),111)

        viewModel.setup(control, filter)

        assertEquals(viewModel.player, player1)
        assertEquals(viewModel.player.pid, 2)
        assertEquals(viewModel.player.cid, 222)
        assertEquals(viewModel.player.curr_money, 100)
        assertEquals(viewModel.player.layer0, 11)
        assertEquals(viewModel.player.layer1, 22)
        assertEquals(viewModel.player.layer2, 33)
        assertEquals(viewModel.player.layer3, 44)
        assertEquals(viewModel.player.layer4, 55)
        assertEquals(viewModel.player.layer5, 66)
        assertEquals(viewModel.player.layer6, 77)
        assertEquals(viewModel.player.layer7, 88)
    }

//    @Test
//    fun testFetchCountries(){
//        val country1 = Country(1, "Canada", 500, "developed country")
//        val country2 = Country(2, "China", 300, "developing country")
//        val country3 = Country(3, "Niger", 100, "underdeveloped country")
//        whenever(countryDAO.getAllCountries()).thenReturn(
//            flow {
//                emit(listOf(country1, country2, country3))
//            }
//        )
//        val player1 = Player(2, 222, 100, 11, 22, 33,
//            44, 55, 66,77, 88)
//
//        whenever(playerDAO.getAllPlayers()).thenReturn(
//            flow {
//                emit(listOf(player1))
//            }
//        )
//
//    }

    @Test
    fun testFetchItems() = runBlocking {
        val item1 = Item(1, "item1", 10, 3,5)
        val item2 = Item(2, "item2", 20, 10, 10)
        val item3 = Item(3, "item3", 30, 20, 15)
        val control = NavControl(mock())
        val filter = TaskUiState.FilterTask(1, mutableStateOf(true),111)


        whenever(itemDAO.getAllItems()).thenReturn(
            flow {
                emit(listOf(item1, item2, item3))
            }
        )
        viewModel.fetchItems()
        assertEquals(viewModel.shopIidCountMap[1]?.value, 0)
        assertEquals(viewModel.shopIidCountMap[2]?.value, 0)
        assertEquals(viewModel.shopIidCountMap[3]?.value, 0)
        assertEquals(viewModel.allIIdItemsMap[1], ItemConverter.databaseEntityToUiState(item1))
        assertEquals(viewModel.allIIdItemsMap[2], ItemConverter.databaseEntityToUiState(item2))
        assertEquals(viewModel.allIIdItemsMap[3], ItemConverter.databaseEntityToUiState(item3))
        assertEquals(1, ItemConverter.databaseEntityToUiState(item1).iid)
        assertEquals(2, ItemConverter.databaseEntityToUiState(item2).iid)
        assertEquals(3, ItemConverter.databaseEntityToUiState(item3).iid)
        assertEquals("item1", ItemConverter.databaseEntityToUiState(item1).name)
        assertEquals("item2", ItemConverter.databaseEntityToUiState(item2).name)
        assertEquals("item3", ItemConverter.databaseEntityToUiState(item3).name)
        assertEquals(10, ItemConverter.databaseEntityToUiState(item1).quantity)
        assertEquals(20, ItemConverter.databaseEntityToUiState(item2).quantity)
        assertEquals(30, ItemConverter.databaseEntityToUiState(item3).quantity)
        assertEquals(3, ItemConverter.databaseEntityToUiState(item1).price)
        assertEquals(10, ItemConverter.databaseEntityToUiState(item2).price)
        assertEquals(20, ItemConverter.databaseEntityToUiState(item3).price)
        assertEquals(5, ItemConverter.databaseEntityToUiState(item1).mark)
        assertEquals(10, ItemConverter.databaseEntityToUiState(item2).mark)
        assertEquals(15, ItemConverter.databaseEntityToUiState(item3).mark)
    }

    @Test
    fun testGetSelectableItemList(){
        val item1 = Item(1, "item1", 10, 3,5)
        val item2 = Item(2, "item2", 20, 10, 10)
        val item3 = Item(3, "item3", 30, 20, 15)
        val control = NavControl(mock())
        val filter = TaskUiState.FilterTask(1, mutableStateOf(true),111)


        whenever(itemDAO.getAllItems()).thenReturn(
            flow {
                emit(listOf(item1, item2, item3))
            }
        )
        viewModel.fetchItems()
        assertEquals(viewModel.getSelectableItemList()[0], ItemConverter.databaseEntityToUiState(item1))
        assertEquals(viewModel.getSelectableItemList()[1], ItemConverter.databaseEntityToUiState(item2))
        assertEquals(viewModel.getSelectableItemList()[2], ItemConverter.databaseEntityToUiState(item3))
    }


    @Test
    fun testAdd(){
        viewModel.shopIidCountMap[0] = mutableStateOf(0)
        viewModel.add(0)
        assertEquals(1, viewModel.shopIidCountMap[0]?.value ?: -1)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
}
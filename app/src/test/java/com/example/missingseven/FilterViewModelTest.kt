package com.example.missingseven

import androidx.compose.runtime.mutableStateOf
import com.example.missingseven.Database.DAO.CountryDAO
import com.example.missingseven.Database.DAO.ItemDAO
import com.example.missingseven.Database.DAO.PlayerDAO
import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.Database.Entity.Player
import com.example.missingseven.Database.IntPair
import com.example.missingseven.Database.PrefManager
import com.example.missingseven.Database.Repository.CountryRepository
import com.example.missingseven.Database.Repository.ItemRepository
import com.example.missingseven.Database.Repository.PlayerRepository
import com.example.missingseven.Model.ItemConverter
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.Navigation.NavControl
import com.example.missingseven.ViewModel.FilterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FilterViewModelTest {
    private val playerDAO: PlayerDAO = mock()
    private val countryDAO: CountryDAO = mock()
    private val itemDAO: ItemDAO = mock()

    private val prefManager: PrefManager = mock()
    private val playerRepository = PlayerRepository(prefManager, playerDAO)
    private val countryRepository = CountryRepository(countryDAO, prefManager)
    private val itemRepository = ItemRepository(prefManager, itemDAO)

    private lateinit var viewModel: FilterViewModel
    private val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup(){
        viewModel = FilterViewModel(
            playerRepository,
            countryRepository,
            itemRepository
        )
        Dispatchers.setMain(dispatcher)
        whenever(prefManager.getInt(IntPair.CurrTask)).thenReturn(9)
    }


    @Test
    fun testFilterViewModelSetup() = runBlocking {
        val player1 = Player(2, 222, 100, 10, 20, 11, 22, 33,
            44, 55, 66,77, 88, true)

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
        val player1 = Player(2, 222, 100, 10, 20, 11, 22, 33,
            44, 55, 66,77, 88, true)

        whenever(playerDAO.getAllPlayers()).thenReturn(
            flow {
                emit(listOf(player1))
            }
        )

        viewModel.fetchPlayer()

        assertEquals(viewModel.player, player1)
        assertEquals(viewModel.player.pid, 2)
        assertEquals(viewModel.player.cid, 222)
        assertEquals(viewModel.player.curr_money, 100)
        assertEquals(viewModel.player.neck, 10)
        assertEquals(viewModel.player.mouth, 20)
        assertEquals(viewModel.player.layer0, 11)
        assertEquals(viewModel.player.layer1, 22)
        assertEquals(viewModel.player.layer2, 33)
        assertEquals(viewModel.player.layer3, 44)
        assertEquals(viewModel.player.layer4, 55)
        assertEquals(viewModel.player.layer5, 66)
        assertEquals(viewModel.player.layer6, 77)
        assertEquals(viewModel.player.layer7, 88)
    }

    @Test
    fun testFetchItems() = runBlocking {
        val item1 = Item(1, "item1", 10, 3, 5.0F,
            3.0F, listOf(0.8F, 0.5F), listOf(0.7F, 0.4F))
        val item2 = Item(2, "item2", 20, 10, 10.0F,
            10.0F, listOf(0.85F, 0.55F), listOf(0.75F, 0.45F))
        val item3 = Item(3, "item3", 30, 20, 15.0F,
            12.0F, listOf(0.4F, 0.2F), listOf(0.3F, 0.1F))


        whenever(itemDAO.getAllItems()).thenReturn(
            flow {
                emit(listOf(item1, item2, item3))
            }
        )
        viewModel.fetchItems()
        assertEquals(0, viewModel.shopIidCountMap[1]?.value)
        assertEquals(0, viewModel.shopIidCountMap[2]?.value)
        assertEquals(0, viewModel.shopIidCountMap[3]?.value)
        assertEquals(ItemConverter.databaseEntityToUiState(item1), viewModel.allIIdItemsMap[1])
        assertEquals(ItemConverter.databaseEntityToUiState(item2), viewModel.allIIdItemsMap[2])
        assertEquals(ItemConverter.databaseEntityToUiState(item3), viewModel.allIIdItemsMap[3])
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
        assertEquals(5.0F, ItemConverter.databaseEntityToUiState(item1).strength)
        assertEquals(10.0F, ItemConverter.databaseEntityToUiState(item2).strength)
        assertEquals(15.0F, ItemConverter.databaseEntityToUiState(item3).strength)
        assertEquals(3.0F, ItemConverter.databaseEntityToUiState(item1).cleanedStrength)
        assertEquals(10.0F, ItemConverter.databaseEntityToUiState(item2).cleanedStrength)
        assertEquals(12.0F, ItemConverter.databaseEntityToUiState(item3).cleanedStrength)
        assertEquals(listOf(0.8F, 0.5F), ItemConverter.databaseEntityToUiState(item1).effectiveness)
        assertEquals(listOf(0.85F, 0.55F), ItemConverter.databaseEntityToUiState(item2).effectiveness)
        assertEquals(listOf(0.4F, 0.2F), ItemConverter.databaseEntityToUiState(item3).effectiveness)
        assertEquals(listOf(0.7F, 0.4F), ItemConverter.databaseEntityToUiState(item1).cleanedEffectiveness)
        assertEquals(listOf(0.75F, 0.45F), ItemConverter.databaseEntityToUiState(item2).cleanedEffectiveness)
        assertEquals(listOf(0.3F, 0.1F), ItemConverter.databaseEntityToUiState(item3).cleanedEffectiveness)

    }

    @Test
    fun testGetSelectableItemList(){
        val item1 = Item(1, "item1", 10, 3, 5.0F,
            3.0F, listOf(0.8F, 0.5F), listOf(0.7F, 0.4F))
        val item2 = Item(2, "item2", 20, 10, 10.0F,
            10.0F, listOf(0.85F, 0.55F), listOf(0.75F, 0.45F))
        val item3 = Item(3, "item3", 30, 20, 15.0F,
            12.0F, listOf(0.4F, 0.2F), listOf(0.3F, 0.1F))


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


//    @Test
//    fun testSelectItem(){
//        val item1 = Item(1, "item1", 10, 3, 5.0F,
//            3.0F, listOf(0.8F, 0.5F), listOf(0.7F, 0.4F))
//        val item2 = Item(2, "item2", 20, 10, 10.0F,
//            10.0F, listOf(0.85F, 0.55F), listOf(0.75F, 0.45F))
//        val item3 = Item(3, "item3", 30, 20, 15.0F,
//            12.0F, listOf(0.4F, 0.2F), listOf(0.3F, 0.1F))
//        val player1 = Player(2, 222, 100, 10, 20, 11, 22, 33,
//            44, 55, 66,77, 88, true)
//
//        whenever(playerDAO.getAllPlayers()).thenReturn(
//            flow {
//                emit(listOf(player1))
//            }
//        )
//        val control = NavControl(mock())
//        val filter = TaskUiState.FilterTask(1, mutableStateOf(true),111)
//
//        viewModel.setup(control, filter)
//        assertEquals(viewModel.filterStack.add())
//    }


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
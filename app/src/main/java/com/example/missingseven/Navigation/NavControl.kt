package com.example.missingseven.Navigation

import android.os.Parcelable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.missingseven.Screen.HomeScreen
import com.example.missingseven.Screen.InstructionScreen
import com.example.missingseven.Screen.ShopScreen
import com.example.missingseven.Screen.TaskScreen
import com.example.missingseven.Screen.WaterFilterScreen
import com.example.missingseven.ViewModel.TaskViewModel
import kotlinx.parcelize.Parcelize

class NavControl constructor(
    private val navController: NavHostController,
) {

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun SetUpNavGraph() {
        val viewModel: TaskViewModel = hiltViewModel()
        viewModel.setup(this@NavControl)

        val waterFilterViewModel: WaterFilterViewModel = hiltViewModel()
        waterFilterViewModel.initData()

        NavHost(navController = navController, startDestination = Screen.Home.route) {

            composable(route = Screen.Home.route){
                HomeScreen(viewModel)
            }

            composable(route = Screen.Task.route){
                TaskScreen(viewModel)
            }

            composable(route = Screen.WaterFilter.route){
                WaterFilterScreen(waterFilterViewModel)
            }

            composable(route = Screen.Shop.route){
                ShopScreen(viewModel = hiltViewModel(navController.previousBackStackEntry!!))
            }

            composable(route = Screen.Instruction.route){
                InstructionScreen(viewModel = hiltViewModel(navController.previousBackStackEntry!!))
            }
        }
    }

    fun navigate(backRoute: String, destinationRoute: String, paramSet: ParamSet? = null){
        navController.getBackStackEntry(backRoute).savedStateHandle.set(
                key = destinationRoute,
                value = paramSet
        )
        navController.navigate(destinationRoute){
            popUpTo(backRoute)
        }
    }

    fun getArguments(route: String): ParamSet? {
        navController.previousBackStackEntry?.savedStateHandle.let {
            return it?.get<ParamSet>(route)
        }
    }

    fun navigateBack(){
        navController.popBackStack()
    }

}


sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Task: Screen("task")
    object Instruction: Screen("instruction")
    object Shop: Screen("shop")
    object ItemSelect: Screen("item select")

    object WaterFilter: Screen("Water Filter")
}

sealed class ParamSet : Parcelable {

//    @Parcelize
//    data class CheckoutParamSet(
//        val itemList: List<ItemUiState>,
//        val totalPrice: Int,
//    ): ParamSet()

}
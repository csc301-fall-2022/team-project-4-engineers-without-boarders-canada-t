package com.example.missingseven.Navigation

import android.os.Parcelable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.missingseven.Model.ItemUiState
import com.example.missingseven.Screen.*
import com.example.missingseven.ViewModel.FilterViewModel
import com.example.missingseven.ViewModel.TaskViewModel
import kotlinx.parcelize.Parcelize

class NavControl constructor(
    private val navController: NavHostController,
) {

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun SetUpNavGraph() {
        val viewModel: TaskViewModel = hiltViewModel()
        val filterViewModel: FilterViewModel = hiltViewModel()
        viewModel.setup(this@NavControl)


        NavHost(navController = navController, startDestination = Screen.Home.route) {

            composable(route = Screen.Home.route){
                HomeScreen(viewModel)
            }

            composable(route = Screen.Task.route){
                TaskScreen(viewModel, filterViewModel)
            }

            composable(route = Screen.Shop.route){
                ShopScreen(viewModel = filterViewModel)
            }

            composable(route = Screen.ItemSelect.route){
                ItemSelectScreen(viewModel = filterViewModel)
            }

            composable(route = Screen.Instruction.route){
                InstructionScreen(viewModel = filterViewModel)
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

}

sealed class ParamSet : Parcelable {

}
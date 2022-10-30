package com.example.missingseven.Navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.missingseven.Screen.HomeScreen
import com.example.missingseven.Screen.TaskScreen
import com.example.missingseven.ViewModel.TaskViewModel

class NavControl constructor(
    private val navController: NavHostController,
) {

    @Composable
    fun SetUpNavGraph() {
        val viewModel: TaskViewModel = hiltViewModel()
        viewModel.setup(this@NavControl)


        NavHost(navController = navController, startDestination = Screen.Home.route) {

            composable(route = Screen.Home.route){
                HomeScreen(viewModel)
            }

            composable(route = Screen.Task.route){
                TaskScreen(viewModel)
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

}

sealed class ParamSet : Parcelable {

//    @Parcelize
//    data class CheckoutParamSet(
//        val itemList: List<ItemUiState>,
//        val totalPrice: Int,
//    ): ParamSet()

}
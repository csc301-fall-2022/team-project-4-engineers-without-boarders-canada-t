package com.example.missingseven.Screen

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import com.example.missingseven.ViewModel.TaskViewModel
import com.example.missingseven.Navigation.Screen

@Composable
fun HomeScreen(
    viewModel: TaskViewModel
){
    Button(onClick = { viewModel.navControl.navigate(Screen.Home.route, Screen.Task.route) }) {

    }
}
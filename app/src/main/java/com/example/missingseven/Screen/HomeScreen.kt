package com.example.missingseven.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.missingseven.ViewModel.TaskViewModel
import com.example.missingseven.Navigation.Screen

@Composable
fun HomeScreen(
    viewModel: TaskViewModel
) {

    Column {

        Button(onClick = {
            if (viewModel.allFetched.value) {
                viewModel.navControl.navigate(Screen.Home.route, Screen.Task.route)
            }
        }) {
            Text(text = "Task")
        }
        Button(onClick = {
            viewModel.navControl.navigate(Screen.Home.route, Screen.WaterFilter.route)
        }) {
            Text(text = "WaterFilter")
        }
    }
}
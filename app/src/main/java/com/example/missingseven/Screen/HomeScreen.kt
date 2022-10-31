package com.example.missingseven.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.missingseven.ViewModel.TaskViewModel
import com.example.missingseven.Navigation.Screen
import com.example.missingseven.ViewModel.InstructionViewModel

@Composable
fun HomeScreen(
    viewModel: TaskViewModel,
    instructionModel: InstructionViewModel
) {
    Column(Modifier.padding(16.dp)) {
        Button(onClick = {
            if (viewModel.allFetched.value) {
                viewModel.navControl.navigate(Screen.Home.route, Screen.Task.route)
            }
        }) {
            Text(text = "Task")
        }
        Button(onClick = {
            if (instructionModel.allFetched.value) {
                instructionModel.navControl.navigate(Screen.Home.route, Screen.Instruction.route)
            }
        }) {
            Text(text = "Instruction")
        }
    }
}
package com.example.missingseven.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun InstructionScreen(
    viewModel: FilterViewModel
){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = viewModel.getInstruction())
        Button(onClick = { viewModel.closeInstruction() }) {
            Text(text = "Close")
        }
    }
}
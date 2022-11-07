package com.example.missingseven.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun InstructionScreen(
    viewModel: FilterViewModel
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Instructions:", textAlign = TextAlign.Center, fontSize = 20.sp)
        Text(text = viewModel.getInstruction(), modifier = Modifier.padding(10.dp).fillMaxHeight(0.7f))
        Button(onClick = { viewModel.closeChildScreen() }) {
            Text(text = "Close")
        }
    }
}
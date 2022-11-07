package com.example.missingseven.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun HomeScreen(
    viewModel: TaskViewModel
){

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        val color = if (viewModel.isResumeAble()) Color.Green else Color.Gray
        Text(text = "Welcome to W4TW workshop!", fontSize = 20.sp, textAlign = TextAlign.Center)
        Button(onClick = {
            if (viewModel.isResumeAble()){
                viewModel.resume()
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier.padding(10.dp)) {
            Text(text = "Resume Workshop")
        }
        Button(onClick = {
            viewModel.startNewWorkshop()
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "Start new workshop")
        }
    }
}
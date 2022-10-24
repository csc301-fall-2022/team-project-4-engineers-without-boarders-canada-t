package com.example.missingseven.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.missingseven.Database.Entity.TaskType

import com.example.missingseven.Model.TaskUiState

@Preview
@Composable
fun TaskTemplate(
    content: @Composable () -> Unit = { Surface() {
        Text(text = "Hello")
    }
    },
    taskUiState: TaskUiState = TaskUiState(1, mutableStateOf(false), TaskType.ReadingTask(1, "HI", "hi" )),
    backHandler: () -> Unit = {},
    nextHandler: () -> Unit = {}
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(10.dp)) {
        content()
        Spacer(modifier = Modifier.weight(1f))
        Row() {
            Button(onClick =  backHandler ) {
                Text(text = "Back")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = nextHandler,
            colors = ButtonDefaults.buttonColors(backgroundColor = if (taskUiState.completed.value) Color.Green else Color.Gray)) {
                Text(text = "Next")
            }
        }
    }
}
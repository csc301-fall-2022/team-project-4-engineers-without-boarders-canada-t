package com.example.missingseven.Component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.Model.TaskUiState

@Preview
@Composable
fun SlidingScaleTaskBody(
    completeHandler: (Int) -> Unit = {},
    task: TaskUiState.SlidingScaleTask = TaskUiState.SlidingScaleTask(2,
        mutableStateOf(false),
        "How many days are there in a year?",
        100,
        500,
        10,
        365,
        mutableStateOf(-1))
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(10.dp)
    ){
        Text(
            text = task.content,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )

        var sliderPosition by remember { mutableStateOf(task.start) }
        Text(
            text = sliderPosition.toString(),
            modifier = Modifier.paddingFromBaseline(top =60.dp)
        )
        Slider(value = sliderPosition.toFloat(),
            onValueChange = { sliderPosition = it.toInt() },
            valueRange = task.start.toFloat()..task.end.toFloat(),
            steps = task.scale,
            modifier = Modifier.paddingFromBaseline(top =5.dp)
        )

    }
}
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
import com.example.missingseven.Model.TaskUiState

@Composable
fun SlidingScaleTaskBody(
    valueChangeHandler: (Int) -> Unit,
    task: TaskUiState.SlidingScaleTask
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Row(
            modifier = Modifier.padding(top = 60.dp, start = 12.dp, end = 12.dp)
        ) {
            Text(text = toFriendlyNumber(task.start))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = toFriendlyNumber(task.end))
        }
        Slider(
            value = task.current.value.toFloat(),
            onValueChange = { valueChangeHandler(it.toInt()) },
            valueRange = task.start.toFloat()..task.end.toFloat(),
            enabled = !task.completed.value
        )
        Text(
            text = "Use the slider to place your answer",
            modifier = Modifier.padding(top =5.dp)
        )
        Text(text = toFriendlyNumber(task.current.value))
        Text(
            text = displayedText(task),
            modifier = Modifier.padding(top =5.dp)
        )
    }
}

private fun toFriendlyNumber(number: Int) =
    if (number < 1000){
        "$number Million"
    } else {
        "${(number.toFloat() / 1000) * 100 / 100} Billion"
    }

private fun displayedText(task: TaskUiState.SlidingScaleTask) =
    with(task.current.value) {
    if (this < task.correct - task.offset){
        task.tooSmallInfo
    } else if (this > task.correct + task.offset){
        task.tooLargeInfo
    } else {
        task.correctInfo
    }
}
package com.example.missingseven.Component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.missingseven.Model.TaskUiState
import kotlin.math.roundToInt

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
        Text(
            text = displayedText(task),
            modifier = Modifier.padding(top =5.dp, bottom = 60.dp)
        )
        Text(
            text = "Use the slider to place your answer",
            modifier = Modifier.padding(top =5.dp, bottom = 5.dp)
        )
        Text(
            text = toFriendlyNumber(task.current.value),
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
        Row(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp)
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
    }
}

private fun toFriendlyNumber(number: Int) =
    if (number < 1000){
        "$number Million"
    } else {
        // round to 2 decimal places
        "${((number.toFloat() / 1000) * 100).roundToInt().toFloat() / 100} Billion"
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
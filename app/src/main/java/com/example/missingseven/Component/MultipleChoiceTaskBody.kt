package com.example.missingseven.Component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyScopeMarker
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.missingseven.Model.TaskUiState

@Preview
@Composable
@LazyScopeMarker
fun MultipleChoiceTaskBody(
    completeHandler: (Int) -> Unit = {},
    task: TaskUiState.MultipleChoiceTask = TaskUiState.MultipleChoiceTask(1,
        mutableStateOf(false),
"When was the book “To Kill a Mockingbird” by Harper Lee published?",
        listOf<String>("1950", "1960", "1970", "1980"),
        1,
        mutableStateOf(-1))
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = task.header,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
        LazyColumn () {
            itemsIndexed(task.options) { index, option ->
                MultipleChoiceOption(
                    index = index,
                    correctIndex = task.studentAnswerIndex.value,
                    onSelected = { completeHandler(index) },
                    content = option
                )
            }
        }
    }
}
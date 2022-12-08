package com.example.missingseven.Component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.missingseven.Model.TaskUiState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

@Composable
fun ReadingTaskBody(
    task: TaskUiState.ReadingTask
){
    if (!task.isSpecial) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = task.content,
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
    else{
        FilterBuildingIntroBody()
    }
}
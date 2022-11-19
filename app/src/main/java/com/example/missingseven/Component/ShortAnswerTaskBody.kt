package com.example.missingseven.Component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.example.missingseven.Model.TaskUiState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun ShortAnswerTaskBody(
    saveHandler: () -> Unit,
    task: TaskUiState.ShortAnswerTask,
    answerValueHandler: (String) -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .padding(10.dp)
    ) {
//        Text(
//            text = task.question,
//            style = typography.h5,
//            textAlign = TextAlign.Center
//        )

        OutlinedTextField(
            value = task.answer.value,
            label = { Text(text = "Enter Your Answer") },
            onValueChange = {
                answerValueHandler(it)
            }
        )

        Button(
            modifier =  Modifier.padding(10.dp),
            shape = RoundedCornerShape(50),
            onClick = {saveHandler()}
        ) {
            val text = if (task.completed.value) "Saved" else "Save Answer"
            Text(text = text)
        }
    }
}
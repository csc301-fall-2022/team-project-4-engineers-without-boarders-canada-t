package com.example.missingseven.Component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.missingseven.Model.TaskUiState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.R
import com.example.missingseven.Screen.DeepLinkText

@Composable
fun GlobalLiteracyRateBody(
    task: TaskUiState.GlobalLiteracyRateTask
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = task.content,
            modifier = Modifier.padding(top = 15.dp)
        )

        Image(
            modifier = Modifier.padding(top = 15.dp)
                .fillMaxWidth(),
            painter = painterResource(task.image),
            contentScale = ContentScale.Crop,
            contentDescription = "Global Literacy Rate Image",
        )

        DeepLinkText(
            title = "Source: ",
            link = task.hyperlink,
            deepLinkEnabled = true,
            displayTextForLink = task.hyperlinkText
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun GlobalLiteracyRatePreview(){
    GlobalLiteracyRateBody(
        TaskUiState.GlobalLiteracyRateTask(
            0, mutableStateOf(true), "Global Literacy Rate",
            "The literacy rate is defined by the percentage of the population of " +
                    "a given age group that can read and write.",
            R.drawable.glrm,
            "Our World in Data",
            "www.google.com"
        )
    )
}
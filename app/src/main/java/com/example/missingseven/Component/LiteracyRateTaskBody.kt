package com.example.missingseven.Component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyScopeMarker
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.R

@SuppressLint("UnrememberedMutableState")
@Composable
@LazyScopeMarker
fun LiteracyRateTaskBody(
    completeHandler: () -> Unit = {},
    task: TaskUiState.LiteracyRateTask
) {
    var selected_country by remember {
        mutableStateOf("");
    }
//    var Canada_selected: MutableState<Boolean> = mutableStateOf(false);
    val scrollState by remember {
        mutableStateOf(ScrollState(0))
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                0.dp,
                brush = SolidColor(Color.Black),
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxHeight(0.7f)
            .verticalScroll(scrollState)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Scroll down to complete the question",
                color = Color.Red
            )
            Text(
                text = "Explore the literacy rates of the highlighted countries: (click on the country name buttons to see the literacy rate)",
//            style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(R.drawable.lrm),
                contentDescription = "Literacy Rate Map",
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = {selected_country = "Canada"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Canada")
                }
                Button(
                    onClick = {selected_country = "Germany"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Germany")
                }
                Button(
                    onClick = {selected_country = "Ghana"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Ghana")
                }
            }
            Row() {
                Button(
                    onClick = {selected_country = "Kuwait"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Kuwait")
                }
                Button(
                    onClick = {selected_country = "Malawi"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Malawi")
                }
                Button(
                    onClick = {selected_country = "Kenya"},
                ) {
                    Text(text = "Kenya")
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {selected_country = "South Africa"},
                ) {
                    Text(text = "South Africa")
                }
            }

            when (selected_country){
                "Canada" -> Text(
                    text = "Literacy rate of Canada is: " + task.CanadaRate + "%",
                    textAlign = TextAlign.Center
                )
                "Germany" -> Text(
                    text = "Literacy rate of Germany is: " + task.GermanyRate + "%",
                    textAlign = TextAlign.Center
                )
                "Ghana" -> Text(
                    text = "Literacy rate of Ghana is: " + task.GhanaRate + "%",
                    textAlign = TextAlign.Center
                )
                "Kenya" -> Text(
                    text = "Literacy rate of Kenya is: " + task.KenyaRate + "%",
                    textAlign = TextAlign.Center
                )
                "Kuwait" -> Text(
                    text = "Literacy rate of Kuwait is: " + task.KuwaitRate + "%",
                    textAlign = TextAlign.Center
                )
                "Malawi" -> Text(
                    text = "Literacy rate of Malawi is: " + task.MalawiRate + "%",
                    textAlign = TextAlign.Center
                )
                "South Africa" -> Text(
                    text = "Literacy rate of South Africa is: " + task.SouthAfricaRate + "%",
                    textAlign = TextAlign.Center
                )
                else -> Text(
                    text = "",
                    textAlign = TextAlign.Center
                )
            }

            Text(
                text = "Which of these countries have the lowest rates?",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 35.dp)
            )
            OutlinedTextField(
                value = task.studentAnswer.value,
                label = { Text(text = "Enter Your Answer") },
                onValueChange = {
                    task.studentAnswer.value = it;
                }
            )

            Button(
                modifier =  Modifier.padding(10.dp),
                shape = RoundedCornerShape(50),
                onClick = {completeHandler()}
            ) {
                val text = "Submit"
                Text(text = text)
            }

            if(task.completed.value){
                Text(
                    text = task.successPopUp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun LiteracyRatePreview(){
    LiteracyRateTaskBody(
        {},
        TaskUiState.LiteracyRateTask(0, mutableStateOf(false), "The literacy rate is defined by the\n" +
                "percentage of the population of a given age group that can read and write.", 99F, 99F, 79.04F, 81.54F, 96.46F, 62.14F, 95.02F,
            mutableStateOf(""), "Yes, literacy rates are lowest in the Sub-Saharan African countries."
        )
    )
}
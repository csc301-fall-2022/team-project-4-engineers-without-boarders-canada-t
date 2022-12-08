package com.example.missingseven.Component

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyScopeMarker
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.R

@SuppressLint("UnrememberedMutableState")
@Composable
@LazyScopeMarker
fun LiteracyRateTaskBody(
    submitHandler: () -> Unit = {},
    task: TaskUiState.LiteracyRateTask
) {
    var selectedCountry by remember {
        mutableStateOf("");
    }
//    var Canada_selected: MutableState<Boolean> = mutableStateOf(false);
    val scrollState by remember {
        mutableStateOf(ScrollState(0))
    }
    var successPopup by remember {
        mutableStateOf(false)
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
                    onClick = {selectedCountry = "Canada"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Canada")
                }
                Button(
                    onClick = {selectedCountry = "Germany"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Germany")
                }
                Button(
                    onClick = {selectedCountry = "Ghana"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Ghana")
                }
            }
            Row() {
                Button(
                    onClick = {selectedCountry = "Kuwait"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Kuwait")
                }
                Button(
                    onClick = {selectedCountry = "Malawi"},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Text(text = "Malawi")
                }
                Button(
                    onClick = {selectedCountry = "Kenya"},
                ) {
                    Text(text = "Kenya")
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {selectedCountry = "South Africa"},
                ) {
                    Text(text = "South Africa")
                }
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
                    task.studentAnswer.value = it
                }
            )

            Button(
                modifier =  Modifier.padding(10.dp),
                shape = RoundedCornerShape(50),
                onClick = {
                    submitHandler()
                    successPopup = true
                }
            ) {
                val text = "Submit"
                Text(text = text)
            }

        }
        if (selectedCountry.isNotEmpty()){
            Popup(
                onDismissRequest = { selectedCountry = "" },
                alignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(24.dp)
                        .background(Color.White)
                        .border(
                            0.dp,
                            brush = SolidColor(Color.Black),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    val text = when(selectedCountry){
                        "Canada" -> "Literacy rate of Canada is: " + task.CanadaRate + "%"
                        "Germany" -> "Literacy rate of Germany is: " + task.GermanyRate + "%"
                        "Ghana" -> "Literacy rate of Ghana is: " + task.GhanaRate + "%"
                        "Kenya" -> "Literacy rate of Kenya is: " + task.KenyaRate + "%"
                        "Kuwait" -> "Literacy rate of Kuwait is: " + task.KuwaitRate + "%"
                        "Malawi" -> "Literacy rate of Malawi is: " + task.MalawiRate + "%"
                        "South Africa" -> "Literacy rate of South Africa is: " +
                                task.SouthAfricaRate + "%"
                        else -> ""
                    }
                    Text(
                        text = text,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        if (successPopup){
            Popup(
                onDismissRequest = { successPopup = false },
                alignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(24.dp)
                        .background(Color.White)
                        .border(
                            0.dp,
                            brush = SolidColor(Color.Black),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Text(
                        text = if (task.completed.value) task.successPopUp else "Wrong Answer",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
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
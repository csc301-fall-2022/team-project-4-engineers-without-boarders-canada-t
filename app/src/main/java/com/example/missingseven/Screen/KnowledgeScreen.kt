package com.example.missingseven.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.Component.TaskTemplate
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.R
import com.example.missingseven.ViewModel.FilterViewModel
import com.example.missingseven.ui.theme.TextContent
import com.example.missingseven.ui.theme.TextDes

@Composable
fun KnowledgeScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        val value = remember { mutableStateOf(-1) }
        val scrollState = rememberScrollState()
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Where do most of the people without clean water access live",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.fillMaxWidth(0.7f)
            )

            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.w4tw),
                contentDescription = "Water For The World",
                modifier = Modifier.size(130.dp)
            )
        }
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { value.value = 0 }
                    .fillMaxWidth()
            ) {
                RadioButton(selected = value.value == 0, onClick = null)
                Text(text = "North America", Modifier.padding(8.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { value.value = 1 }
                    .fillMaxWidth()
            ) {
                RadioButton(selected = value.value == 1, onClick = null)
                Text(text = "South America", Modifier.padding(8.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { value.value = 2 }
                    .fillMaxWidth()
            ) {
                RadioButton(selected = value.value == 2, onClick = null)
                Text(text = "Europe", Modifier.padding(8.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { value.value = 3 }
                    .fillMaxWidth()
            ) {
                RadioButton(selected = value.value == 3, onClick = null)
                Text(text = "Asia", Modifier.padding(8.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { value.value = 4 }
                    .fillMaxWidth()
            ) {
                RadioButton(selected = value.value == 4, onClick = null)
                Text(text = "Africa", Modifier.padding(8.dp))
            }
        }
        Image(
            painter = painterResource(id = R.mipmap.ic_knowledge_world),
            contentDescription = "img",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        if (value.value == 4) {
            Column(
                Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = "Popup upon correct answer",
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 10.dp),
                    color = Color.Red,
                    fontSize = 16.sp
                )
                Text(
                    text = "Yes, most of the people in the world living without clean water live in Sub-Saharan Africa - the part of Africa south of the Sahara.",
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 10.dp),
                    color = TextContent,
                    fontSize = 16.sp
                )
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }
        Image(
            painter = painterResource(R.drawable.ewb),
            contentDescription = "engineers without borders",
            modifier = Modifier.size(100.dp)
        )
        Row {
            Button(onClick = {}) {
                Text(text = "Back")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {}) {
                Text(text = "Next")
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun KnowledgeScreenPreview() {
    KnowledgeScreen()
}
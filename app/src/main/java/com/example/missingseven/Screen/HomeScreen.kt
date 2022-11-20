package com.example.missingseven.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.R
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun HomeScreen(
    viewModel: TaskViewModel
){

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.w4tw),
                contentDescription = "Water For The World",
                modifier = Modifier.size(250.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ewb),
            contentDescription = "engineers without borders",
            modifier = Modifier.size(300.dp)
        )
        Text(text = "This App is a joint project by W4TW", fontSize = 20.sp)
        Text(text = "World and EWB-Canada!", fontSize = 20.sp)
        val color = if (viewModel.isResumeAble()) Color.Green else Color.Gray
        Button(onClick = {
            if (viewModel.isResumeAble()){
                viewModel.resume()
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier.padding(10.dp)) {
            Text(text = "Resume Workshop")
        }
        Button(onClick = {
            viewModel.startNewWorkshop()
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "Start new workshop")
        }
    }
}
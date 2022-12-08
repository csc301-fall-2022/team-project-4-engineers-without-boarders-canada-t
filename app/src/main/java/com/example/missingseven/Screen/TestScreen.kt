package com.example.missingseven.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.missingseven.R
import com.example.missingseven.ViewModel.FilterViewModel
import kotlin.math.round

@Composable
fun TestScreen(
    viewModel: FilterViewModel,
    exitClick: () -> Unit
) {
    val score = round(viewModel.filterStack.evaluation() * 100 / 100)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(text = "FILTER TEST STATION")
        viewModel.getPlayerCountry()?.let { 
            Text(text = it.name)
        }
        Image(painter = painterResource(
            id = R.drawable.filter_test),
            contentDescription = "filter test")
        Text(text = "Your dirty water is now ${score}% cleaned")
        Text(text = if (score < 65) {
            "DO NOT DRINK - you may get sick and die!!"
        } else {
            "CONGRATULATIONS - you can drink this water - it is clean enough to drink"
        })

        Button(onClick = viewModel::navigateBack) {
            Text(text = "BACK to filter build")
        }
        Button(onClick = viewModel::tryAnotherCountry) {
           Text(text = "TRY ANOTHER COUNTRY")
        }
        Button(onClick = exitClick) {
            Text(text = "EXIT filter building")
        }
    }
}
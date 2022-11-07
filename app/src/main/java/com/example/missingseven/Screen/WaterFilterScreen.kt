package com.example.missingseven.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.missingseven.Component.WaterFilter
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.Navigation.NavControl
import com.example.missingseven.R
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun WaterFilterScreen(
    task: TaskUiState.FilterTask,
    filterViewModel: FilterViewModel,
    navControl: NavControl,
    taskCompleteHandler: () -> Unit
) {
    LaunchedEffect(Unit){
        if (!filterViewModel.setupCompleted.value){
            filterViewModel.setup(navControl, task)
        }
    }
    if (filterViewModel.setupCompleted.value){
        Column() {
            Text(text = "Country: " + filterViewModel.getPlayerCountry()?.name.orEmpty())
            Text(text = "Money: " + filterViewModel.playerUiState.currMoney.value)
            WaterFilter(stack = filterViewModel.filterStack) { filterViewModel.onStackClicked() }
            Row(verticalAlignment = Alignment.Bottom) {
                IconButton(onClick = { filterViewModel.shopClicked()}) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_shop),
                        contentDescription = "Shop",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Button(onClick = { filterViewModel.openInstruction() }) {
                    Text(text = "Instruction")
                }
                Button(onClick = {
                    taskCompleteHandler()
                }) {
                    Text(text = "Evaluate")
                }
            }
            if (task.completed.value){
                Text(text = "You have scored ${filterViewModel.playerScore()}/10 on your water filter!", modifier = Modifier.padding(10.dp))
            }
        }
    }
}
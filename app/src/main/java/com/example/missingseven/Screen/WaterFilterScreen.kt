package com.example.missingseven.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.Component.WaterFilter
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.Navigation.NavControl
import com.example.missingseven.Navigation.Screen
import com.example.missingseven.R
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun WaterFilterScreen(
    task: TaskUiState.FilterTask,
    filterViewModel: FilterViewModel,
    navControl: NavControl,
    nextClick: () -> Unit,
    taskCompleteHandler: () -> Unit
) {
    LaunchedEffect(Unit){
        filterViewModel.setup(navControl, task)
    }

    if (filterViewModel.fetchCompleted()){
        if (filterViewModel.player.cid == -1){
            val pair = filterViewModel.getParallelCountryList()
            CountryScreen(
                listA = pair.first,
                listB = pair.second,
            countryClick = {country -> filterViewModel.countrySelect(country) }){
                filterViewModel.navigateBack()
            }
        } else {
            if (!filterViewModel.setupCompleted.value){
                filterViewModel.setupPlayerUiState()
                filterViewModel.setupStack()
            } else {
                FilterMainBody(task = task, filterViewModel = filterViewModel, nextClick) {
                    taskCompleteHandler()
                }
            }

        }
    }
}

@Composable
fun FilterMainBody(
    task: TaskUiState.FilterTask,
    filterViewModel: FilterViewModel,
    nextClick: () -> Unit,
    taskCompleteHandler: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Country: " + filterViewModel.getPlayerCountry()?.name.orEmpty(),
            fontSize = 15.sp)
        Text(text = "Money: " + filterViewModel.playerUiState.currMoney.value
            , modifier = Modifier.padding(vertical = 10.dp), fontSize = 15.sp)
        WaterFilter(stack = filterViewModel.filterStack, task.completed.value) {
            filterViewModel.onStackClicked() }
        Row(modifier = Modifier.padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center) {
            IconButton(onClick = { filterViewModel.shopClicked()},
                modifier = Modifier.padding(horizontal = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier.size(40.dp)
                )
            }
            Button(onClick = { filterViewModel.openInstruction() },
                modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(text = "Instruction")
            }
            Button(onClick = {
                taskCompleteHandler()
            }, modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(text = "Evaluate")
            }
        }
        val text = if (task.completed.value) "You have scored" +
                " ${filterViewModel.playerScore()}/10 on your water filter!" else
            "Warning: You cannot edit your filter once you click evaluate!"
        Text(text = text, modifier = Modifier.padding(10.dp))
        if (task.completed.value){
            Button(onClick = { nextClick() }) {
                Text(text = "Next")
            }
        }
    }
}
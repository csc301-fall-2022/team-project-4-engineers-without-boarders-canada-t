package com.example.missingseven.Screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.missingseven.Database.Entity.TaskType
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun FilterMainScreen(
    // TODO replace task's type with FilterTask when ready
    task: TaskType,
    filterViewModel: FilterViewModel
) {
    LaunchedEffect(Unit){
        filterViewModel.setup(task)
    }
}
package com.example.missingseven.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun ItemSelectScreen(
    viewModel: FilterViewModel
){
    LazyColumn(){
        items(viewModel.getSelectableItemList()){ item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .clickable {
                    viewModel.selectItem(item)
                }) {
                Text(text = item.name, modifier = Modifier.padding(horizontal = 10.dp))
                Text(text = "Quantity: ${item.quantity}")
            }
        }
    }
}
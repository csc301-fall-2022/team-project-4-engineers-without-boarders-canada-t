package com.example.missingseven.Screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.ViewModel.FilterViewModel

@Composable
fun ItemSelectScreen(
    viewModel: FilterViewModel
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Select a material:", textAlign = TextAlign.Center, fontSize = 20.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp))
        LazyColumn(modifier = Modifier.fillMaxHeight(0.8f)){
            items(viewModel.getSelectableItemList()){ item ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(40.dp)
                    .clickable {
                        viewModel.selectItem(item)
                    }
                    .border(
                        1.dp,
                        brush = SolidColor(Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    ), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = item.name, modifier = Modifier.padding(horizontal = 10.dp))
                    Text(text = "Quantity: ${item.quantity}")
                }
            }
        }
        Button(onClick = { viewModel.closeChildScreen() }) {
            Text(text = "Close")
        }
    }
}
package com.example.missingseven.Component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.missingseven.Model.FilterStack
import com.example.missingseven.Model.ItemUiState

@Composable
fun WaterFilter(
    stack: FilterStack,
    isEvaluated: Boolean
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        LazyColumn(){
            itemsIndexed(items = stack.displayedStack()){ index, item ->
                val boarderColor = stack.getBoarderColor(index)
                FilterGrid(item = item, boarderColor = boarderColor, isEvaluated = isEvaluated, widthPercentage = 0.9f)
            }
        }
        FilterGrid(item = stack.neck.value, boarderColor = stack.getNeckColor(), isEvaluated = isEvaluated, widthPercentage = 0.7f )
        FilterGrid(item = stack.mouth.value, boarderColor = stack.getMouthColor(), isEvaluated = isEvaluated, widthPercentage = 0.5f)
    }
}

@Composable
fun FilterGrid(
    item: ItemUiState?,
    boarderColor: Color,
    isEvaluated: Boolean,
    widthPercentage: Float
){
    Box(
        modifier = Modifier
            .fillMaxWidth(widthPercentage)
            .height(40.dp)
            .border(
                1.dp,
                brush = SolidColor(boarderColor),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ){
        if (boarderColor == Color.Green){
            val text = if (isEvaluated) "You have evaluated, unable to add materials!"
            else "Click to add material"
            Text(text = text)
        } else {
            item?.let {
                Text(it.name)
            }
        }
    }
}
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
import androidx.compose.ui.unit.dp
import com.example.missingseven.Model.FilterStack

@Composable
fun WaterFilter(
    stack: FilterStack,
    isEvaluated: Boolean,
    clickHandler: () -> Unit,
){
    LazyColumn(
        modifier = Modifier.clickable {
            clickHandler()
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        itemsIndexed(items = stack.displayedStack()){ index, item ->
            val boarderColor = stack.getBoarderColor(index)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
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
                    else "Click to add material here!"
                    Text(text = text)
                } else {
                    item?.let {
                        Text(it.name)
                    }
                }
            }
        }
    }
}
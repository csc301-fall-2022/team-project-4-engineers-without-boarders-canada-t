package com.example.missingseven.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.missingseven.Model.FilterStack

@Composable
fun WaterFilter(
    stack: FilterStack,
    clickHandler: () -> Unit
){
    LazyColumn(
        modifier = Modifier.clickable {
            clickHandler()
        }
    ){
        itemsIndexed(items = stack.displayedStack()){ index, item ->
            val boarderColor = stack.getBoarderColor(index)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .border(
                        0.dp,
                        brush = SolidColor(boarderColor),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(10.dp)
            ){
                item?.let {
                    Text(it.name)
                }
            }
        }
    }
}
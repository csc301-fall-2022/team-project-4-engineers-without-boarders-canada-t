package com.example.missingseven.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.missingseven.Model.ItemUiState
import com.example.missingseven.ViewModel.FilterViewModel
import com.example.missingseven.ui.theme.ItemBg

@ExperimentalFoundationApi
@Composable
fun ShopScreen(
    viewModel: FilterViewModel
) {
    val playerUiState = viewModel.playerUiState

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 16.dp)) {
            Text(
                textAlign = TextAlign.Center,
                text = "Country:\n${playerUiState.countryName}",
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                textAlign = TextAlign.Center,
                text = "Money:\n${playerUiState.currMoney.value}",
                fontSize = 32.sp
            )
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(0.6f)
                .border(
                    0.dp,
                    brush = SolidColor(Color.Black),
                    shape = RoundedCornerShape(5.dp)
                ),
        ) {
            val itemList = mutableListOf<ItemUiState>()
            itemList.addAll(viewModel.allIIdItemsMap.values)
            items(itemList.size) { index ->
                CardView(item = itemList[index],
                    subHandler = {iid -> viewModel.sub(iid) },
                    addHandler = {iid -> viewModel.add(iid)},
                    viewModel.shopIidCountMap[itemList[index].iid]!!.value
                )
            }
        }
        Text(text = "Total price: ${viewModel.totalPrice()}")
        Button(onClick = {
                         if (viewModel.checkoutAble()){
                             viewModel.checkout()
                         } },
            modifier = Modifier.padding(top = 10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = if (viewModel.checkoutAble()) Color.Green else Color.Gray)) {
            Text(text = "Checkout")
        }
    }
}

@Composable
fun CardView(item: ItemUiState,
             subHandler: (Int) -> Unit,
             addHandler: (Int) -> Unit,
             count: Int) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                0.dp,
                brush = SolidColor(Color.Black),
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Card(
            backgroundColor = ItemBg,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(6.dp)
            ) {
//                Image(
//                    painter = painterResource(id = item.img),
//                    contentDescription = "img",
//                    modifier = Modifier.size(100.dp, 100.dp)
//                )
                Text(
                    text = "price:${item.price}",
                    modifier = Modifier.padding(6.dp)
                )
                Text(
                    text = item.name,
                    modifier = Modifier.padding(6.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { subHandler(item.iid) }, modifier = Modifier.size(40.dp)) {
                        Text(text = "-")
                    }
                    Text(
                        text = "$count",
                        modifier = Modifier.padding(6.dp)
                    )
                    Button(onClick = { addHandler(item.iid) }, modifier = Modifier.size(40.dp)) {
                        Text(text = "+")
                    }
                }
            }
        }
    }
}
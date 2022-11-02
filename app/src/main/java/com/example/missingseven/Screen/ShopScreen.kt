package com.example.missingseven.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    InitView(viewModel)
}

@ExperimentalFoundationApi
@Composable
fun InitView(viewModel: FilterViewModel) {
    val itemList = rememberUpdatedState { viewModel.itemList }
    val playerUiState = rememberUpdatedState { viewModel.playerUiState }

    Column {
        Row(modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)) {
            Text(
                textAlign = TextAlign.Center,
                text = "Country:\n${playerUiState.value.invoke()?.countryName}",
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                textAlign = TextAlign.Center,
                text = "Money:\n${playerUiState.value.invoke()?.currMoney}",
                fontSize = 32.sp
            )
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(8.dp),
        ) {
            items(itemList.value.invoke().size) { index ->
                CardView(item = itemList.value.invoke()[index], index = index, viewModel = viewModel)
            }
        }
    }
}


@Composable
fun CardView(item: ItemUiState, index: Int, viewModel: FilterViewModel) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Card(
            backgroundColor = ItemBg,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = item.img),
                    contentDescription = "img",
                    modifier = Modifier.size(100.dp, 100.dp)
                )
                Text(
                    text = "price:${item.price}",
                    modifier = Modifier.padding(8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { viewModel.sub(index) }) {
                        Text(text = "-")
                    }
                    Text(
                        text = "${item.quantity}",
                        modifier = Modifier.padding(8.dp)
                    )
                    Button(onClick = { viewModel.add(index) }) {
                        Text(text = "+")
                    }
                }
            }
        }
    }
}


@ExperimentalFoundationApi
@Preview
@Composable
fun Preview() {
    val viewModel: FilterViewModel = hiltViewModel()
    viewModel.loadData()
    InitView(viewModel)
}

package com.example.missingseven.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.missingseven.R
import com.example.missingseven.ViewModel.WaterFilterViewModel


@Composable
fun WaterFilterScreen(
    viewModel: WaterFilterViewModel
) {
    val data = rememberUpdatedState { viewModel.data }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Water Filter",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(all = 16.dp)
        )
        LazyColumn(Modifier.weight(1f)) {
            itemsIndexed(viewModel.data) { index, item ->
                var img by remember { mutableStateOf(item.img) }
                if (img == 0) {
                    Text(
                        text = "Empty",
                        textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp)
                            .clickable {
                                img = R.mipmap.ic_water_filter
                                viewModel.click(index)
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(id = img),
                        contentDescription = "item",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                Modifier.weight(1f)
            ) {
                Text(text = "Instruction")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { /*TODO*/ },
                Modifier.weight(1f)
            ) {
                Text(text = "Evaluation")
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun WaterFilterPreview() {
    val viewModel: WaterFilterViewModel = hiltViewModel()
    viewModel.initData()
    WaterFilterScreen(viewModel)
}
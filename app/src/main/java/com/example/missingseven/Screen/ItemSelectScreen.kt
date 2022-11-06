package com.example.missingseven.Screen

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
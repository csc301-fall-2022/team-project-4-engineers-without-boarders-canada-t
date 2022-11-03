package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.R

class ItemConverter {

    companion object {
        fun databaseEntityToUiState(item: Item?){
            return item.run {
                if (this is Item) {
                    ItemUiState(
                        iid,
                        name,
                        quantity,
                        price,
                        R.mipmap.ic_launcher
                    )
                }
            }
        }
    }
}
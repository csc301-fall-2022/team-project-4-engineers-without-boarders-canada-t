package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.R

class ItemConverter {

    companion object {
        fun databaseEntityToUiState(item: Item): ItemUiState{
            return item.run {
                    ItemUiState(
                        iid,
                        name,
                        quantity,
                        price,
                        R.mipmap.ic_launcher,
                        mark)
            }
        }
    }
}
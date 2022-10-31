package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.ItemType

class ItemConverter {

    companion object {
        fun databaseEntityToUiState(itemType: ItemType?){
            return itemType.run {
                if (this is ItemType.Item) {
                    ItemUiState.Item(
                        iid,
                        quantity,
                        price
                    )
                }
            }
        }
    }
}
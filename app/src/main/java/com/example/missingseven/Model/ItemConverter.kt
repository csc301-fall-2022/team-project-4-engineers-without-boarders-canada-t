package com.example.missingseven.Model

import androidx.compose.runtime.mutableStateOf
import com.example.missingseven.Database.Entity.ItemType
import com.example.missingseven.R

class ItemConverter {

    companion object {
        fun databaseEntityToUiState(itemType: ItemType?){
            return itemType.run {
                if (this is ItemType) {
                    ItemUiState(
                        iid,
                        quantity,
                        price,
                        R.mipmap.ic_launcher
                    )
                }
            }
        }
    }
}
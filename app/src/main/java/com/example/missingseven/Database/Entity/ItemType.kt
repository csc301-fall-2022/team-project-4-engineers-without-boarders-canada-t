package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

sealed class ItemType(
    open val iid: Int,
    open var quantity: Int,
    open var price: Int) {
    data class Item(
        @PrimaryKey override val iid: Int,
        @ColumnInfo override var quantity: Int,
        @ColumnInfo override var price: Int
    ) : ItemType(iid, quantity, price)

    companion object {
        const val ITEM_TYPE_NUM = 5
    }
}
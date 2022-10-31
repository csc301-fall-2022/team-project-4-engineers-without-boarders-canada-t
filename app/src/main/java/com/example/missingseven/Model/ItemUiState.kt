package com.example.missingseven.Model

sealed class ItemUiState(
    open val iid: Int,
    open var quantity: Int,
    open var price: Int
) {
    data class Item(
        override val iid: Int,
        override var quantity: Int,
        override var price: Int
    ) : ItemUiState(iid, quantity, price)
}
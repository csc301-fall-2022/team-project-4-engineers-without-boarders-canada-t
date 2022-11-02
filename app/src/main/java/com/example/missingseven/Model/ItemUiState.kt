package com.example.missingseven.Model

import android.os.Parcelable
import androidx.compose.runtime.MutableState
import kotlinx.parcelize.Parcelize

@Suppress("UNCHECKED_CAST")
@Parcelize
data class ItemUiState(
    val iid: Int,
    val name: String,
    var quantity: Parcelable,
    var price: Int,
    var img: Int
): Parcelable {
    fun getQuantity(): MutableState<Int> {
        return quantity as MutableState<Int>
    }
}
package com.example.missingseven.Model

import android.os.Parcelable
import androidx.compose.runtime.MutableState
import kotlinx.parcelize.Parcelize

data class ItemUiState(
    val iid: Int,
    val name: String,
    var quantity: Int,
    var price: Int,
    var img: Int
)
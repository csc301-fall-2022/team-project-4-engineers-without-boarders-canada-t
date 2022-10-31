package com.example.missingseven.Model

sealed class CountryUiState(
    open val cid: Int,
    open val name: String,
    open val money: Int,
    open val instruction: String
) {
    data class Country(
        override val cid: Int,
        override val name: String,
        override val money: Int,
        override val instruction: String
    ) : CountryUiState(cid, name, money, instruction)
}
package com.example.missingseven.Model

import androidx.compose.runtime.mutableStateOf
import com.example.missingseven.Database.Entity.CountryType

class CountryConverter {

    companion object {
        fun databaseEntityToUiState(countryType: CountryType?) {
            return countryType.run {
                if (this is CountryType.Country) {
                    CountryUiState.Country(
                        cid,
                        name,
                        money,
                        instruction
                    )
                }
            }
        }
    }
}
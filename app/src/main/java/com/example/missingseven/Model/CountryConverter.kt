package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.Country

class CountryConverter {

    companion object {
        fun databaseEntityToUiState(country: Country?) {
            return country.run {
                if (this is Country) {
                    CountryUiState(
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
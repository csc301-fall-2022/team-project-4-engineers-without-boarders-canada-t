package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.CountryDAO
import com.example.missingseven.Database.Entity.Country
import javax.inject.Inject
import javax.security.auth.callback.Callback

class CountryRepository @Inject constructor(private val countryDAO: CountryDAO) {
    suspend fun getAllCountries(callback: (List<Country>) -> Unit) {
        countryDAO.getAllCountries().collect {
            callback(it)
        }
    }

    suspend fun insertAllCountries(countries: List<Country>, callback: () -> Unit) {
        countryDAO.insertAllCountries(countries).run { callback() }
    }
}
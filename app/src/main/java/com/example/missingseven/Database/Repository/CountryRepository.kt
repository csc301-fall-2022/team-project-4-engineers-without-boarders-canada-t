package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.CountryDAO
import javax.inject.Inject
import javax.security.auth.callback.Callback

class CountryRepository @Inject constructor(private val countryDAO: CountryDAO) {
    suspend fun get(){
        countryDAO.getAllCountries()
    }

    suspend fun insertAllCountries(countries: List<String>, callback: () -> Unit){
        countryDAO.insertAllCountries(countries).run { callback }
    }
}
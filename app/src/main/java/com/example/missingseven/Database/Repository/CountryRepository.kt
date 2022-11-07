package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.CountryDAO
import com.example.missingseven.Database.Entity.Country
import com.example.missingseven.Database.IntPair
import com.example.missingseven.Database.PrefManager
import javax.inject.Inject
import javax.security.auth.callback.Callback

class CountryRepository @Inject constructor(
    private val countryDAO: CountryDAO, private val prefManager: PrefManager) {
    suspend fun getAllCountries(callback: (List<Country>) -> Unit){
        countryDAO.getAllCountries().collect() {
            if (prefManager.getInt(IntPair.CurrTask) != -1 && prefManager.getInt(IntPair.CurrTask) != -0){
                callback(it)
            }
        }
    }

    suspend fun insertAllCountries(countries: List<Country>, callback: () -> Unit){
        countryDAO.insertAllCountries(countries).run { callback() }
    }

    suspend fun deleteCountries(callback: () -> Unit){
        countryDAO.deleteAllCountries().run {
            callback()
        }
    }
}
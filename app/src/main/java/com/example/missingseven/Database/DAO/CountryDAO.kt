package com.example.missingseven.Database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDAO {
    @Query("SELECT * FROM country")
    fun getAllCountries(): Flow<List<Country>>

    @Insert
    suspend fun insertAllCountries(countries: List<Country>)

    @Delete
    suspend fun deleteCountry(country: Country)
}
package com.example.missingseven.Database.DAO
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.TaskType

@Dao
interface CountryDAO {
    @Query("SELECT * FROM countrylist")
    fun getAllCountries()

    @Insert
    suspend fun insertAllCountries(countries: List<String>)

    @Delete
    suspend fun deleteCountry(country: String)
}
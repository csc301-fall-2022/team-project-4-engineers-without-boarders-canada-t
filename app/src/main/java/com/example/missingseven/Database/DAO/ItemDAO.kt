package com.example.missingseven.Database.DAO
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.TaskType

@Dao
interface ItemDAO {
    @Query("SELECT * FROM item")
    fun getAllItems()

    @Insert
    suspend fun insertAllItems(items: List<String>)

    @Delete
    suspend fun deleteItem(item: String)
}
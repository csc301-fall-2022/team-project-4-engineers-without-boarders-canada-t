package com.example.missingseven.Database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO {
    @Query("SELECT * FROM item")
    fun getAllItems(): Flow<List<Item>>

    @Insert
    suspend fun insertAllItems(items: List<Item>)

    @Delete
    suspend fun deleteItem(item: Item)
}
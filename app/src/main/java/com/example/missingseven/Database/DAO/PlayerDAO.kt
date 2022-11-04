package com.example.missingseven.Database.DAO
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.TaskType

interface PlayerDAO {
    @Query("SELECT * FROM playerlist")
    fun getAllPlayers()

    @Insert
    suspend fun insertAllPlayers(players: List<String>)

    @Delete
    suspend fun deletePlayer(player: String)
}
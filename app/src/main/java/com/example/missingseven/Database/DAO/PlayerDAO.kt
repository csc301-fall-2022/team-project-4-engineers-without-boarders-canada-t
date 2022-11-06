package com.example.missingseven.Database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.missingseven.Database.Entity.Player

@Dao
interface PlayerDAO {
    @Query("SELECT * FROM player")
    fun getAllPlayers()

    @Insert
    suspend fun insertAllPlayers(players: List<Player>)

    @Delete
    suspend fun deletePlayer(player: Player)
}
package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.PlayerDAO
import com.example.missingseven.Database.Entity.Player
import javax.inject.Inject

class PlayerRepository @Inject constructor(private val playerDAO: PlayerDAO) {
    suspend fun getPlayers(callback: (List<Player>) -> Unit) {
        playerDAO.getAllPlayers()
    }

    suspend fun insertPlayers(players: List<Player>, callback: (List<Player>) -> Unit) {
        playerDAO.insertAllPlayers(players).run { callback }
    }

    suspend fun updatePlayer(player: Player) {

    }
}
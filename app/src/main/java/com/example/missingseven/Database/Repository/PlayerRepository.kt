package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.PlayerDAO
import javax.inject.Inject

class PlayerRepository @Inject constructor(private val playerDAO: PlayerDAO) {
    suspend fun getPlayers(callback: (List<String>) -> Unit){
        playerDAO.getAllPlayers()
    }

    suspend fun insertPlayers(players: List<String>, callback: (List<String>) -> Unit){
        playerDAO.insertAllPlayers(players).run { callback }
    }
}
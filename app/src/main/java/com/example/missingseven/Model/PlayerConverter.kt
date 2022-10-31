package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.PlayerType
class PlayerConverter {

    companion object {
        fun databaseEntityToUiState(playerType: PlayerType, countryName: String, instructions: String) {
            return playerType.run {
                PlayerUiState(
                    cid,
                    pid,
                    curr_money,
                    countryName,
                    instructions
                )
            }
        }
    }
}
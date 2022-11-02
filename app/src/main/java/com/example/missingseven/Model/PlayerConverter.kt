package com.example.missingseven.Model

import androidx.compose.runtime.mutableStateOf
import com.example.missingseven.Database.Entity.Player
class PlayerConverter {

    companion object {
        fun databaseEntityToUiState(playerType: Player, countryName: String, instructions: String) {
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
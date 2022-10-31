package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.PlayerType
import com.example.missingseven.Model.PlayerUiState
class PlayerConverter {

    companion object {
        fun databaseEntityToUiState(playerType: PlayerType?) {
            return playerType.run {
                if(this is PlayerType.Player) {
                    PlayerUiState.Player(
                        cid,
                        pid,
                        curr_money
                    )
                }
            }
        }
    }
}
package com.example.missingseven.Model

import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.R

class ItemConverter {

    companion object {
        fun databaseEntityToUiState(item: Item): ItemUiState{
            return item.run {
                    ItemUiState(
                        iid,
                        name,
                        quantity,
                        price,
                        getImageRes(iid),
                        strength,
                        cleanedStrength,
                        effectiveness,
                        cleanedEffectiveness)
            }
        }

        fun UiStateToDatabaseEntity(item: ItemUiState): Item{
            return item.run {
                Item(
                    iid,
                    name,
                    quantity,
                    price,
                    strength,
                    cleanedStrength,
                    effectiveness,
                    cleanedEffectiveness
                )
            }
        }

        private fun getImageRes(iid: Int): Int {
            return when (iid){
                1 -> R.drawable.rubberband
                2 -> R.drawable.cheesecloth
                3 -> R.drawable.cotton
                4 -> R.drawable.finesand
                5 -> R.drawable.coarsesand
                6 -> R.drawable.finegravel
                7 -> R.drawable.coarsegravel
                else -> -1
            }
        }
    }
}
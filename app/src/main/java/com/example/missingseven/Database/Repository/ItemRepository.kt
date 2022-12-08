package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.ItemDAO
import com.example.missingseven.Database.Entity.Item
import com.example.missingseven.Database.IntPair
import com.example.missingseven.Database.PrefManager
import javax.inject.Inject
import javax.security.auth.callback.Callback

class ItemRepository @Inject constructor(
    private val prefManager: PrefManager,
    private val itemDAO: ItemDAO
) {
    suspend fun getItems(callback: (List<Item>)->Unit){
        itemDAO.getAllItems().collect {
            if (prefManager.getInt(IntPair.CurrTask) == 9){
                callback(it)
            }
        }
    }

    suspend fun insertAllItems(items: List<Item>, callback: ()->Unit){
        itemDAO.insertAllItems(items).run { callback() }
    }

    suspend fun updateItem(item: Item){
        itemDAO.updateItem(item)
    }

    suspend fun deleteAllItems(callback: () -> Unit){
        itemDAO.deleteAllItems().run {
            callback()
        }
    }

}
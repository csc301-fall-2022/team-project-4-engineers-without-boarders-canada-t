package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.ItemDAO
import com.example.missingseven.Database.Entity.Item
import javax.inject.Inject
import javax.security.auth.callback.Callback

class ItemRepository @Inject constructor(
    private val itemDAO: ItemDAO
) {
    suspend fun getItems(callback: (List<Item>)->Unit){
        itemDAO.getAllItems()
    }

    suspend fun insertAllItems(items: List<Item>, callback: ()->Unit){
        itemDAO.insertAllItems(items).run { callback() }
    }

    suspend fun updateItem(item: Item){

    }
}
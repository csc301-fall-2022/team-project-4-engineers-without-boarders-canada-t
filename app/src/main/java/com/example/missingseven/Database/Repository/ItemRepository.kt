package com.example.missingseven.Database.Repository

import com.example.missingseven.Database.DAO.ItemDAO
import javax.inject.Inject
import javax.security.auth.callback.Callback

class ItemRepository @Inject constructor(
    private val itemDAO: ItemDAO
) {
    suspend fun getItems(callback: (List<String>)->Unit){
        itemDAO.getAllItems()
    }

    suspend fun insertAllItems(items: List<String>, callback: ()->Unit){
        itemDAO.insertAllItems(items).run { callback() }
    }
}
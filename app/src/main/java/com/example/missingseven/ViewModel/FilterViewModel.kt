package com.example.missingseven.ViewModel

import androidx.lifecycle.ViewModel
import com.example.missingseven.Model.ItemUiState
import com.example.missingseven.Model.PlayerUiState
import com.example.missingseven.R
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
) : ViewModel() {

     var itemList = mutableListOf<ItemUiState>()
     var playerUiState :PlayerUiState?= null

    fun loadData() {
        playerUiState = PlayerUiState(
            0,
            0,
            100,
            "China",
            "the People's Republic of China"
        )
        itemList.add(ItemUiState(0, 1, 10, R.mipmap.ic_demo))
        itemList.add(ItemUiState(1, 10, 100, R.mipmap.ic_demo))
        itemList.add(ItemUiState(2, 20, 200, R.mipmap.ic_demo))
        itemList.add(ItemUiState(3, 30, 300, R.mipmap.ic_demo))
        itemList.add(ItemUiState(4, 40, 400, R.mipmap.ic_demo))
        itemList.add(ItemUiState(5, 50, 500, R.mipmap.ic_demo))
        itemList.add(ItemUiState(6, 60, 600, R.mipmap.ic_demo))
        itemList.add(ItemUiState(7, 70, 700, R.mipmap.ic_demo))
        itemList.add(ItemUiState(8, 80, 800, R.mipmap.ic_demo))
        itemList.add(ItemUiState(9, 90, 900, R.mipmap.ic_demo))
        changeMoney()
    }

    fun sub(index: Int) {
        itemList[index].quantity -= 1
        if (itemList[index].quantity <= 0) {
            itemList.removeAt(index)
        }
        changeMoney()
    }

    fun add(index: Int) {
        itemList[index].quantity += 1
        changeMoney()
    }

    private fun changeMoney() {
        var newMoney = BigDecimal.ZERO
        for (item in itemList) {
            val money = BigDecimal(item.quantity).multiply(BigDecimal(item.price))
            newMoney = newMoney.add(money)
            println("money = ${money}, quantity = ${item.quantity}, price = ${item.price}")
            println(newMoney.toInt())
        }
        playerUiState?.currMoney = newMoney.toInt()
    }
}
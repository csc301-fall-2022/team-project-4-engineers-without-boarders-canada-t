package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemType(
    @PrimaryKey val iid: Int,
    @ColumnInfo var quantity: Int,
    @ColumnInfo var price: Int

)
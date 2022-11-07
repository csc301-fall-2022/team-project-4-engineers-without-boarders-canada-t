package com.example.missingseven.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val iid: Int,
    @ColumnInfo val name: String,
    @ColumnInfo var quantity: Int,
    @ColumnInfo var price: Int,
    @ColumnInfo val mark: Int

)
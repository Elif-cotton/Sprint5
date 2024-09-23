package com.example.shoestap.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoes")
data class Shoe(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val price: Int,
    val formattedPrice: String,
    val desc: String
)

fun formatPriceClp(price: Int): String {
    return "$$price CLP"
}
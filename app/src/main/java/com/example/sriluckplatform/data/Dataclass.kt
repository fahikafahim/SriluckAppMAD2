package com.example.sriluckplatform.data

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    @DrawableRes val imageResourceId: Int,
    val description: String,
    val category: String,
    val rating: Float,
    val colors: List<String> = listOf("Black", "White", "Blue")
)

data class CartItem(
    val product: Product,
    val quantity: Int,
    val selectedColor: String
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val address: String
)
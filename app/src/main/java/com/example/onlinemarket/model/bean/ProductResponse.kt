package com.example.onlinemarket.model.bean

data class ProductResponse(
    val `data`: ProductData,
    val status: Int
)

data class ProductData(
    val products: List<Product>
)
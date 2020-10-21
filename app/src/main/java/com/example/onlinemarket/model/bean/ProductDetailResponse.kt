package com.example.onlinemarket.model.bean

data class ProductDetailResponse(
    val `data`: SingleProductData,
    val status: Int
)

data class SingleProductData(
    val product: Product,
    val token: String
)

data class Product(
    val id: Int,
    val tagid : Int,
    val introduce: String,
    val name: String,
    val picture: String,
    val price: Double,
    val discount : Double
)
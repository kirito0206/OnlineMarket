package com.example.onlinemarket.model.bean

data class ActionDetailResponse(
    val `data`: ActionDetailData,
    val status: Int
)

data class ActionDetailData(
    val message: Message,
    val token: String
)

data class Message(
    val id: Int,
    val name: String,
    val product: List<Product>,
    val time: String,
    val type: Int
)
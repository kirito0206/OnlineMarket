package com.example.onlinemarket.model.bean

data class ActionResponse(
    val `data`: ActionData,
    val status: Int
)

data class ActionData(
    val activities: List<Action>
)

data class Action(
    val id: Int,
    val name: String,
    val time: String,
    val type: Int
)
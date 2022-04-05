package com.shryne.bricky.model

data class FoundType(
    val type: String,
    val count: Int,
    val items: List<Item>
)
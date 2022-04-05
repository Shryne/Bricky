package com.shryne.bricky.model

data class ProductSearchResult(
    val result: ProductSearchContent,
    val returnCode: Int,
    val returnMessage: String,
    val errorTicket: Int,
    val processingTime: Int
)
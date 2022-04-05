package com.shryne.bricky.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("idItem")
    val id: Int,
    @JsonProperty("typeItem")
    val type: String?,
    @JsonProperty("strItemNo")
    val no: String?,
    @JsonProperty("strItemName")
    val name: String,
)
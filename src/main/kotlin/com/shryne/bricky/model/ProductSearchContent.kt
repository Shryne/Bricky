package com.shryne.bricky.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductSearchContent(
    @JsonProperty("typeList")
    val types: List<FoundType>
)
package com.shryne.bricky.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Catalog(
    @JsonProperty("total_count")
    val totalCount: Int,
    val idColor: Int,
    val rpp: Int,
    val pi: Int,
    @JsonProperty("list")
    val findings: List<Finding>?
)

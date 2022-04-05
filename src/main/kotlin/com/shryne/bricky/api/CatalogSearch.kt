package com.shryne.bricky.api

import com.shryne.bricky.api.parameter.Color
import com.shryne.common.api.asObject
import com.shryne.bricky.model.Catalog
import kong.unirest.Unirest

/**
 * Offers the searching of shops that offer a certain item.
 */
data class CatalogSearch(
    private val itemId: Int,
    private val color: Color,
    private val shippingCountry: Country,
    private val sellerCountry: Country,
    private val condition: Condition
) {
    private val base: String =
        "https://www.bricklink.com/ajax/clone/catalogifs.ajax"

    fun catalog(): Catalog = Unirest.get(
        base +
                "?itemid=$itemId" +
                "&color=${color.id}" +
                "&ss=$shippingCountry" +
                "&loc=$sellerCountry" +
                "&cond=${condition.value}"
    ).asObject()
}

enum class Country {
    DE
}

enum class Condition(val value: String) {
    NEW("N")
}
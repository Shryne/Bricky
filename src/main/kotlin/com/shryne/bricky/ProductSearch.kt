package com.shryne.common.api

import com.shryne.bricky.model.ProductSearchResult
import kong.unirest.GetRequest
import kong.unirest.Unirest

/**
 *
 */
data class ProductSearch(private val name: String) {
    private val base: String =
        "https://www.bricklink.com/ajax/clone/search/searchproduct.ajax"

    fun product(): ProductSearchResult = Unirest.get(
        base + "?q=$name" +
                "&st=0" +
                "&cond=" +
                "&type=" +
                "&cat=" +
                "&yf=0" +
                "&yt=0" +
                "&loc=" +
                "&reg=0" +
                "&ca=0" +
                "&ss=" +
                "&pmt=" +
                "&nmp=0" +
                "&color=-1" +
                "&min=" +
                "0&max=0" +
                "&minqty=0" +
                "&nosuperlot=1" +
                "&incomplete=0" +
                "&showempty=1" +
                "&rpp=25" +
                "&pi=1" +
                "&ci=0"
    ).asObject()
}

inline fun <reified T> GetRequest.asObject(): T = asObject(T::class.java).body
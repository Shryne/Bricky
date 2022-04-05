package com.shryne.bricky.model

data class Finding(
    val idInv: Int,
    val strDesc: String,
    val codeNew: String,
    val codeComplete: String,
    val idInvImg: Int,
    val strInvImgUrl: String,
    val typeInvImg: String?,
    val n4Qty: Int,
    val mInvSalePrice: String,
    val strSellerCountryName: String,
    val strSellerCountryCode: String,
    val strColor: String,
)
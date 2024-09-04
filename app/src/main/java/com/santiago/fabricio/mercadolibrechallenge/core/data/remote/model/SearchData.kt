package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class SearchData (
    @SerializedName("id")
    val id: String,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("price")
    val price: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    @SerializedName("buying_mode")
    val buyingMode: String,
    @SerializedName("listing_type_id")
    val listingTypeId: String,
    @SerializedName("stop_time")
    val stopTime: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    @SerializedName("installments")
    val installments: Installments,
    @SerializedName("shipping")
    val shipping: Shipping,
){
    constructor() : this(
        id = "any id",
        siteId = "any siteId",
        title = "any title",
        seller = Seller(0, ""),
        price = 10.0,
        currencyId = "any currencyId",
        availableQuantity = 10,
        buyingMode = "any buyingMode",
        listingTypeId = "any listingTypeId",
        stopTime = "any shopTime",
        condition = "any condition",
        permalink = "any permalink",
        thumbnail = "any thumbnail",
        acceptsMercadopago = false,
        installments = Installments(0, 0.0, 0.0 ,""),
        shipping = Shipping(false, "", listOf(), "", false)
    )
}
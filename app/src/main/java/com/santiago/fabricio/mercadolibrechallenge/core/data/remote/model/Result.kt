package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class Result (
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
)
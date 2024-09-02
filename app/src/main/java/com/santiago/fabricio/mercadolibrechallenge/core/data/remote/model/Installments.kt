package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class Installments (
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("currency_id")
    val currencyId: String,
)
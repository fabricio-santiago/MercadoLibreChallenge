package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model

import com.google.gson.annotations.SerializedName

data class Seller (
    @SerializedName("id")
    val id: Int,
    @SerializedName("nickname")
    val nickname: String,
)
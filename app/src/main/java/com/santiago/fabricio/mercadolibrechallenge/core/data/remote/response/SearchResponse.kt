package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.response

import com.google.gson.annotations.SerializedName
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Paging
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result

data class SearchResponse(
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("results")
    val results: List<Result>,
)
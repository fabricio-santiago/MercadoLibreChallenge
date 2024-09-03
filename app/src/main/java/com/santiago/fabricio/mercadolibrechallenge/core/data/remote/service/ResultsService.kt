package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ResultsService {

    @GET("sites/MLB/search")
    suspend fun getResults(
        @Query("page") page: Int,
        @Query("q") q: String,
    ): SearchResponse
}
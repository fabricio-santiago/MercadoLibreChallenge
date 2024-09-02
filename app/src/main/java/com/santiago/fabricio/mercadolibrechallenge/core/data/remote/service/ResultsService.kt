package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.response.SearchResponse
import retrofit2.http.GET

interface ResultsService {

    @GET("sites/MLB/search?q=Motorola%20G6")
    suspend fun getResults(
        //@Query("page") page: Int
    ): SearchResponse
}
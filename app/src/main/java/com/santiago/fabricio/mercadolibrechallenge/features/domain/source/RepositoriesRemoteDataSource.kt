package com.santiago.fabricio.mercadolibrechallenge.features.domain.source

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.paging.ResultPageSource
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.response.SearchResponse

interface ResultsRemoteDataSource {
    fun getResultsPageSource(): ResultPageSource
    suspend fun getResults(page: Int): SearchResponse
}
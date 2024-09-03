package com.santiago.fabricio.mercadolibrechallenge.features.data.source

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.paging.ResultPageSource
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.response.SearchResponse
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.SafeApiCaller
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.ResultsService
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource
import javax.inject.Inject

class ResultsRemoteDataSourceImpl @Inject constructor(
    private val service: ResultsService,
    private val safeApiCaller: SafeApiCaller
) : ResultsRemoteDataSource {
    override fun getResultsPageSource(searchText: String): ResultPageSource {
        return ResultPageSource(this, safeApiCaller, searchText)
    }

    override suspend fun getResults(page: Int, searchText: String): SearchResponse {
        return service.getResults(page, searchText)
    }
}
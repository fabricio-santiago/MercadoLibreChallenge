package com.santiago.fabricio.mercadolibrechallenge.features.domain.source

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ResultData

interface ResultsRemoteDataSource {
    suspend fun getResults(searchText: String): ResultData<List<SearchData?>>
}
package com.santiago.fabricio.mercadolibrechallenge.features.domain.repository

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ResultData

interface ResultsRepository {
    suspend fun getResults(searchText: String): ResultData<List<SearchData?>>
}
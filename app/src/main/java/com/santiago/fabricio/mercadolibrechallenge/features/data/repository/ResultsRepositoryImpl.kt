package com.santiago.fabricio.mercadolibrechallenge.features.data.repository

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ResultData
import com.santiago.fabricio.mercadolibrechallenge.features.domain.repository.ResultsRepository
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource

class ResultsRepositoryImpl(
    private val remoteDataSource: ResultsRemoteDataSource
) : ResultsRepository {

    override suspend fun getResults(searchText: String): ResultData<List<SearchData?>> {
        return remoteDataSource.getResults(searchText)
    }
}
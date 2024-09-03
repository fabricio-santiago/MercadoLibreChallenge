package com.santiago.fabricio.mercadolibrechallenge.features.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result
import com.santiago.fabricio.mercadolibrechallenge.features.domain.repository.ResultsRepository
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource
import kotlinx.coroutines.flow.Flow

class ResultsRepositoryImpl(
    private val remoteDataSource: ResultsRemoteDataSource
) : ResultsRepository {
    override fun getResults(pagingConfig: PagingConfig, searchText: String): Flow<PagingData<Result>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getResultsPageSource(searchText)
            }
        ).flow
    }
}
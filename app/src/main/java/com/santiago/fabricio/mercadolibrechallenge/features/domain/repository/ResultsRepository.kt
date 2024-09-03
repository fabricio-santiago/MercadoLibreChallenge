package com.santiago.fabricio.mercadolibrechallenge.features.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result
import kotlinx.coroutines.flow.Flow

interface ResultsRepository {
    fun getResults(pagingConfig: PagingConfig, searchText: String): Flow<PagingData<Result>>
}
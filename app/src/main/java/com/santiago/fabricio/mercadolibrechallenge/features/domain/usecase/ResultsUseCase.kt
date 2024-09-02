package com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result
import com.santiago.fabricio.mercadolibrechallenge.features.domain.repository.ResultsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface ResultsUseCase {
    operator fun invoke(): Flow<PagingData<Result>>
}

class ResultsUseCaseImpl @Inject constructor(
    private val repository: ResultsRepository
) : ResultsUseCase {
    override fun invoke(): Flow<PagingData<Result>> {
        return repository.getResults(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        ).flowOn(Dispatchers.IO)
    }
}
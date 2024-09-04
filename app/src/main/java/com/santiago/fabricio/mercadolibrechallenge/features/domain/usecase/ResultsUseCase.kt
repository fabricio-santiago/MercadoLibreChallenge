package com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ResultData
import com.santiago.fabricio.mercadolibrechallenge.features.domain.repository.ResultsRepository
import javax.inject.Inject

interface ResultsUseCase {
    suspend operator fun invoke(searchText: String): ResultData<List<SearchData?>>
}

class ResultsUseCaseImpl @Inject constructor(
    private val repository: ResultsRepository
) : ResultsUseCase {
    override suspend fun invoke(searchText: String): ResultData<List<SearchData?>> {
        return repository.getResults(
            searchText = searchText,
        )
    }
}
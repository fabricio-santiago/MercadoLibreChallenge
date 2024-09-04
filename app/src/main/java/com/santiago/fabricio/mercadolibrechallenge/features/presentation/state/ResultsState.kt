package com.santiago.fabricio.mercadolibrechallenge.features.presentation.state

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData

sealed class ResultsState{
    data object Loading: ResultsState()
    data object Error: ResultsState()
    data object EmptyData: ResultsState()
    data class SuccessUiState(
        val results: List<SearchData?> = emptyList(),
    ): ResultsState()
}


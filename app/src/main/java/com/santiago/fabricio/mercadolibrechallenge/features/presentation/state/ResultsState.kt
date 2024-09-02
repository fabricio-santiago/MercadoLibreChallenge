package com.santiago.fabricio.mercadolibrechallenge.features.presentation.state

import androidx.paging.PagingData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class ResultsState(
    var results: Flow<PagingData<Result>> = emptyFlow()
)


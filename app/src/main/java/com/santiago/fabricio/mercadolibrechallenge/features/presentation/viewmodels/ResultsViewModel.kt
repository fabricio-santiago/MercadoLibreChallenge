package com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase.ResultsUseCase
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val resultsUseCase: ResultsUseCase
) : ViewModel() {

    var resultsState by mutableStateOf(ResultsState())
        private set

    init {
        getResults()
    }

     private fun getResults() {
         try {
             val results = resultsUseCase.invoke().cachedIn(viewModelScope)
             resultsState = resultsState.copy(results = results)
         } catch (e: Exception){
             resultsState = resultsState.copy(results = flowOf())
         }
    }
}
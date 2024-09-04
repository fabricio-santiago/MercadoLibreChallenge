package com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onEmpty
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onError
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onSuccess
import com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase.ResultsUseCase
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val resultsUseCase: ResultsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ResultsState>(
        ResultsState.Loading
    )

    val uiState: StateFlow<ResultsState>
        get() = _uiState.asStateFlow()

    fun getResults(searchText: String) {
        viewModelScope.launch(Dispatchers.IO) {
            resultsUseCase.invoke(
                searchText = searchText
            ).onSuccess { results ->
                _uiState.update {
                    ResultsState.SuccessUiState(
                        results = results
                    )
                }
            }.onError {
                _uiState.update {
                    ResultsState.Error
                }
            }.onEmpty {
                _uiState.update {
                    ResultsState.EmptyData
                }
            }
        }
    }
}
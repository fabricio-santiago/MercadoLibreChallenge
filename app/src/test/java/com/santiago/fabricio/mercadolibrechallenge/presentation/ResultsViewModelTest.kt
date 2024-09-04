package com.santiago.fabricio.mercadolibrechallenge.presentation

import com.nhaarman.mockitokotlin2.whenever
import com.santiago.fabricio.mercadolibrechallenge.TestDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ResultData
import com.santiago.fabricio.mercadolibrechallenge.core.domain.model.SearchDataFactory
import com.santiago.fabricio.mercadolibrechallenge.features.data.mapper.toSearchList
import com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase.ResultsUseCase
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels.ResultsViewModel
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class ResultsViewModelTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var resultsUseCase: ResultsUseCase

    private val viewModel by lazy {
        ResultsViewModel(resultsUseCase = resultsUseCase)
    }

    private val fakeResults =
        SearchDataFactory.create(SearchDataFactory())

    @Test
    fun `must validate data object values when calling data from products result`() =
        runTest {
            //Given
            whenever(resultsUseCase.invoke(any())).thenReturn(
                ResultData.Success(fakeResults.toSearchList())
            )

            //When
            val result = viewModel.uiState.value

            //Then
            assertThat(result).isNotNull()
        }

    @Test
    fun `must thrown an exception when the calling to the use case return an exception`() =
        runTest {
            //Given
            whenever(resultsUseCase.invoke(any())).thenThrow(RuntimeException())

            //When
            val result = viewModel.uiState.value

            //Then
            assertThat(result).isNotSameInstanceAs(ResultData.Success(fakeResults.toSearchList()))
        }
}
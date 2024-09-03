package com.santiago.fabricio.mercadolibrechallenge.presentation

import androidx.paging.PagingData
import com.nhaarman.mockitokotlin2.whenever
import com.santiago.fabricio.mercadolibrechallenge.TestDispatcherRule
import com.santiago.fabricio.mercadolibrechallenge.features.data.mapper.toRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import com.google.common.truth.Truth.assertThat
import com.santiago.fabricio.mercadolibrechallenge.core.domain.model.SearchResponseFactory
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

    private val fakePagingDataResults = PagingData.from(
        SearchResponseFactory.create().results.toRepository()
    )

    @Test
    fun `must validate paging data object values when calling paging data from characters`() =
        runTest {
            //Given
            whenever(resultsUseCase.invoke()).thenReturn(
                flowOf(fakePagingDataResults)
            )

            //When
            val result = viewModel.resultsState.results.first()

            //Then
            assertThat(result).isNotNull()
        }

    @Test
    fun `must thrown an exception when the calling to the use case return an exception`() =
        runTest {
            //Given
            whenever(resultsUseCase.invoke()).thenThrow(RuntimeException())

            //When
            val result = viewModel.resultsState.results

            //Then
            assertThat(result).isNotSameInstanceAs(fakePagingDataResults)
        }
}
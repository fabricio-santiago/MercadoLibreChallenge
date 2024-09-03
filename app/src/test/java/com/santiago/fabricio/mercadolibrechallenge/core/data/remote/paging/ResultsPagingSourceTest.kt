package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.paging

import androidx.paging.PagingSource
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.santiago.fabricio.mercadolibrechallenge.TestDispatcherRule
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.SafeApiCaller
import com.santiago.fabricio.mercadolibrechallenge.core.domain.model.SearchResponseFactory
import com.santiago.fabricio.mercadolibrechallenge.features.data.mapper.toRepository
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ResultsPagingSourceTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Mock
    lateinit var remoteDataSource: ResultsRemoteDataSource

    @Mock
    lateinit var safeApiCaller: SafeApiCaller

    private val locationsPagingFactory = SearchResponseFactory.create()


    private val resultsPagingSource by lazy {
        ResultPageSource(remoteDataSource = remoteDataSource, safeApiCaller = safeApiCaller, searchText = "")
    }

    @Test
    suspend fun `must return success load result when load is called`() {

        //Given
        whenever(remoteDataSource.getResults(any(), any())).thenReturn(locationsPagingFactory)

        //When
        val result = resultsPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        )

        val resultExpected = listOf(
            SearchResponseFactory.create().results.toRepository()
        )

        //Then
        assertThat(
            PagingSource.LoadResult.Page(
                data = resultExpected,
                prevKey = null,
                nextKey = null
            )
        ).isEqualTo(
            result
        )
    }
}
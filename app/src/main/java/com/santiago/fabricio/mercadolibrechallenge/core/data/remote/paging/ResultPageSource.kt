package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.paging

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.SafeApiCaller
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onEmpty
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onError
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onSuccess
import com.santiago.fabricio.mercadolibrechallenge.features.data.mapper.toRepository
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource
import timber.log.Timber

class ResultPageSource(
    private val remoteDataSource: ResultsRemoteDataSource,
    private val safeApiCaller: SafeApiCaller
) : PagingSource<Int, Result>() {

    companion object {
        const val LIMIT_PAGES = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT_PAGES) ?: anchorPage?.nextKey?.minus(LIMIT_PAGES)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageNumber = params.key ?: 1
        safeApiCaller.safeApiCall {
            remoteDataSource.getResults(pageNumber, "Motorola%20G6")
        }.onSuccess { response ->
            Timber.tag("SUCCESS").e(response.toString());
            return LoadResult.Page(
                data = response.results.toRepository(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (response.results.isEmpty()) null else pageNumber + 1
            )
        }.onEmpty {
            return LoadResult.Error(Throwable())
        }.onError { a ->
            Timber.tag("ERROR").e(a.apiException.httpStatusCode.toString())
            return LoadResult.Error(Throwable())
        }
        return LoadResult.Error(Throwable())
    }
}
package com.santiago.fabricio.mercadolibrechallenge.features.data.source

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.SafeApiCaller
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.ResultsService
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.APIException
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ActionErrorTypeEnum
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.ResultData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onEmpty
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onError
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.onSuccess
import com.santiago.fabricio.mercadolibrechallenge.features.data.mapper.toSearchList
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource
import javax.inject.Inject

class ResultsRemoteDataSourceImpl @Inject constructor(
    private val service: ResultsService,
    private val safeApiCaller: SafeApiCaller
) : ResultsRemoteDataSource {
    override suspend fun getResults(searchText: String): ResultData<List<SearchData?>> {
        var result: ResultData<List<SearchData?>>  =
            ResultData.APIError(APIException(actionErrorType = ActionErrorTypeEnum.HTTP_ERROR))

        safeApiCaller.safeApiCall {
            service.getResults(
                q = searchText
            )
        }.onSuccess { pullRequestResponse ->
            result = ResultData.Success(pullRequestResponse.results.toSearchList())
        }.onEmpty {
            result = ResultData.Empty()
        }.onError {
            result = ResultData.APIError(it.apiException)
        }

        return result
    }
}
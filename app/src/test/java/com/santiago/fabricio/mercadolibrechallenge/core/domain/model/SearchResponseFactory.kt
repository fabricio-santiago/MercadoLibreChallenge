package com.santiago.fabricio.mercadolibrechallenge.core.domain.model

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.response.SearchResponse

class SearchResponseFactory {

    companion object {
        fun create() = run {
            SearchResponse(
                siteId = "any siteId",
                paging = PagingFactory.create(),
                results = listOf(
                    SearchDataFactory.create()
                )
            )
        }
    }
}
package com.santiago.fabricio.mercadolibrechallenge.core.domain.model

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Paging

class PagingFactory {

    companion object {
        fun create() = run {
            Paging(
                total = 10,
                offset = 0,
                limit = 50,
                primaryResults = 0
            )
        }
    }
}
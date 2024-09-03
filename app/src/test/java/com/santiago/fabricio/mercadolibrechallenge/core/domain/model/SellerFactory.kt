package com.santiago.fabricio.mercadolibrechallenge.core.domain.model

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Seller

class SellerFactory {

    companion object {
        fun create() = run {
            Seller(
                id = 1,
                nickname = "any nickname",
            )
        }
    }
}
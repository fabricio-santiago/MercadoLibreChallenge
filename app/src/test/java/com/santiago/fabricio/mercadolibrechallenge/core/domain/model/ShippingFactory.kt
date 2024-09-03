package com.santiago.fabricio.mercadolibrechallenge.core.domain.model

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Shipping

class ShippingFactory {

    companion object {
        fun create() = run {
            Shipping(
                freeShipping = false,
                mode = "any mode",
                tags =  listOf(),
                logisticType = "any logisticType",
                storePickUp = false
            )
        }
    }
}
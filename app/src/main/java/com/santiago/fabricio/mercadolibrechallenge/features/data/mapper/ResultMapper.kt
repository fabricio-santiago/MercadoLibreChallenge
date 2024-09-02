package com.santiago.fabricio.mercadolibrechallenge.features.data.mapper

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Installments
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Result
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Seller
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Shipping

fun List<Result?>.toRepository() = map { result ->
    Result(
        id = result?.id ?: "0",
        siteId = result?.siteId ?: "0",
        title = result?.title ?: "",
        seller = result?.seller ?: Seller(id = 0, nickname = ""),
        price = result?.price ?: 0.0,
        currencyId = result?.currencyId ?: "",
        availableQuantity = result?.availableQuantity ?: 0,
        buyingMode = result?.buyingMode ?: "",
        listingTypeId = result?.listingTypeId ?: "",
        stopTime = result?.stopTime ?: "",
        condition = result?.condition ?: "",
        permalink = result?.permalink ?: "",
        thumbnail = result?.thumbnail ?: "",
        acceptsMercadopago = result?.acceptsMercadopago ?: false,
        installments = result?.installments ?: Installments(quantity = 0, amount = 0.0, rate = 0.0, currencyId = ""),
        shipping = result?.shipping ?: Shipping(freeShipping = false, mode = "", tags = listOf(), logisticType = "", storePickUp = false)
    )
}

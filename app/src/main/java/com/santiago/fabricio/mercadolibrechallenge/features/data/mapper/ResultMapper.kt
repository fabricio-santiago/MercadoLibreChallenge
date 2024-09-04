package com.santiago.fabricio.mercadolibrechallenge.features.data.mapper

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Installments
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Seller
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Shipping

fun List<SearchData?>.toSearchList(): List<SearchData?> = map { searchData ->
    SearchData(
        id = searchData?.id ?: "0",
        siteId = searchData?.siteId ?: "0",
        title = searchData?.title ?: "",
        seller = searchData?.seller ?: Seller(id = 0, nickname = ""),
        price = searchData?.price ?: 0.0,
        currencyId = searchData?.currencyId ?: "",
        availableQuantity = searchData?.availableQuantity ?: 0,
        buyingMode = searchData?.buyingMode ?: "",
        listingTypeId = searchData?.listingTypeId ?: "",
        stopTime = searchData?.stopTime ?: "",
        condition = searchData?.condition ?: "",
        permalink = searchData?.permalink ?: "",
        thumbnail = searchData?.thumbnail ?: "",
        acceptsMercadopago = searchData?.acceptsMercadopago ?: false,
        installments = searchData?.installments ?: Installments(quantity = 0, amount = 0.0, rate = 0.0, currencyId = ""),
        shipping = searchData?.shipping ?: Shipping(freeShipping = false, mode = "", tags = listOf(), logisticType = "", storePickUp = false)
    )
}

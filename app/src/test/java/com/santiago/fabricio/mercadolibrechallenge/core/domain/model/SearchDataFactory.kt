package com.santiago.fabricio.mercadolibrechallenge.core.domain.model


import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData

class SearchDataFactory {

    companion object {
        fun create() = run {
            SearchData(
                id = "any id",
                siteId = "any siteId",
                title = "any title",
                seller = SellerFactory.create(),
                price = 10.0,
                currencyId = "any currencyId",
                availableQuantity = 10,
                buyingMode = "any buyingMode",
                listingTypeId = "any listingTypeId",
                stopTime = "any shopTime",
                condition = "any condition",
                permalink = "any permalink",
                thumbnail = "any thumbnail",
                acceptsMercadopago = false,
                installments = InstallmentsFactory.create(),
                shipping = ShippingFactory.create()
            )
        }
    }
}
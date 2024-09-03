package com.santiago.fabricio.mercadolibrechallenge.core.domain.model

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Installments

class InstallmentsFactory {

    companion object {
        fun create() = run {
            Installments(
                quantity = 10,
                amount = 50.0,
                rate = 20.0,
                currencyId = "any currencyId"
            )
        }
    }
}
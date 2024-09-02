package com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util

import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = request.newBuilder()
            .url(request.url)
            .build()

        return chain.proceed(newRequest)
    }
}
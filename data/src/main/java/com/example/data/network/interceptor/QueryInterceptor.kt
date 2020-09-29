package com.example.data.network.interceptor

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class QueryInterceptor(private val key: String, private val value: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val url: HttpUrl = request.url().newBuilder().addQueryParameter(key, value).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
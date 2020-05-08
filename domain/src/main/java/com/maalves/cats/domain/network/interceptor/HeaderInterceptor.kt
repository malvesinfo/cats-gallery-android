package com.maalves.cats.domain.network.interceptor

import com.maalves.cats.domain.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Authorization", BuildConfig.CLIENT_ID)
                .build()
        )
    }
}
package com.maalves.cats.domain.network

import com.maalves.cats.domain.BuildConfig
import com.maalves.cats.domain.network.interceptor.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val galleryApi by lazy { buildApi(GalleryApi::class.java) }

fun <T> buildApi(`class`: Class<T>): T =
    Retrofit
        .Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(buildOkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(`class`)

private fun buildOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient().newBuilder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor(HeaderInterceptor())

    return builder.build()
}
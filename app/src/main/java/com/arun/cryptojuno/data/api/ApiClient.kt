package com.arun.cryptojuno.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    var instance = Retrofit.Builder().run {
        baseUrl(Urls.BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        client(getClient())
        build()
    }.create(ApiService::class.java)

    private fun getClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(Urls.REQUEST_TIMEOUT_DURATION, TimeUnit.SECONDS)
            .connectTimeout(Urls.REQUEST_TIMEOUT_DURATION, TimeUnit.SECONDS)
            .writeTimeout(Urls.REQUEST_TIMEOUT_DURATION, TimeUnit.SECONDS)
            .build()
    }

}
package com.arun.cryptojuno.data.api

import com.arun.cryptojuno.data.model.CryptoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("empty-home")
    fun getEmptyState() : Call<CryptoData>

    @GET("home")
    fun getValueState() : Call<CryptoData>

}
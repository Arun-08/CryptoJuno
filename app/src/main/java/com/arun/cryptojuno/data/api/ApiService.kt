package com.arun.cryptojuno.data.api

import com.arun.cryptojuno.data.model.CryptoData
import retrofit2.Call
import retrofit2.http.POST

interface ApiService {

    @POST("empty-home")
    fun getEmptyState() : Call<CryptoData>

    @POST("home")
    fun getValueState() : Call<CryptoData>

}
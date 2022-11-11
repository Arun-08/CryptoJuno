package com.arun.cryptojuno.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arun.cryptojuno.data.api.ApiClient
import com.arun.cryptojuno.data.model.CryptoData
import com.arun.cryptojuno.utils.AppResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class CryptoRepo : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    fun requestEmptyState() : LiveData<AppResource<CryptoData>> {
        val listMutableLiveData : MutableLiveData<AppResource<CryptoData>> = MutableLiveData()
        listMutableLiveData.postValue(AppResource.loading())
        launch {
            ApiClient.instance.getEmptyState().enqueue(object : Callback<CryptoData>{
                override fun onResponse(call: Call<CryptoData>, response: Response<CryptoData>) {
                    if(response.isSuccessful){
                        listMutableLiveData.postValue(AppResource.success(response.body()!!))
                    } else {
                        listMutableLiveData.postValue(AppResource.failed())
                    }
                }

                override fun onFailure(call: Call<CryptoData>, t: Throwable) {
                    listMutableLiveData.postValue(AppResource.failed())
                }
            })
        }
        return listMutableLiveData
    }

    fun requestValueState() : LiveData<AppResource<CryptoData>> {
        val listMutableLiveData : MutableLiveData<AppResource<CryptoData>> = MutableLiveData()
        listMutableLiveData.postValue(AppResource.loading())
        launch {
            ApiClient.instance.getValueState().enqueue(object : Callback<CryptoData>{
                override fun onResponse(call: Call<CryptoData>, response: Response<CryptoData>) {
                    if(response.isSuccessful){
                        listMutableLiveData.postValue(AppResource.success(response.body()!!))
                    } else {
                        listMutableLiveData.postValue(AppResource.failed())
                    }
                }

                override fun onFailure(call: Call<CryptoData>, t: Throwable) {
                    listMutableLiveData.postValue(AppResource.failed())
                }
            })
        }
        return listMutableLiveData
    }


}
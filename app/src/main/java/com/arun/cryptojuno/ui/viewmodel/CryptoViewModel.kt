package com.arun.cryptojuno.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arun.cryptojuno.data.model.CryptoData
import com.arun.cryptojuno.data.repository.CryptoRepo
import com.arun.cryptojuno.utils.AppResource

class CryptoViewModel : ViewModel() {


    var repo = CryptoRepo()
    var pageState : Int = 0

    fun makeRequest(): LiveData<AppResource<CryptoData>> {
        return if (pageState == 0) repo.requestEmptyState() else repo.requestValueState()
    }



}
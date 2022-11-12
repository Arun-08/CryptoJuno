package com.arun.cryptojuno.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arun.cryptojuno.data.model.CryptoData
import com.arun.cryptojuno.data.repository.CryptoRepo
import com.arun.cryptojuno.ui.view.adapter.RecentTransactionAdapter
import com.arun.cryptojuno.utils.AppResource

class CryptoViewModel : ViewModel() {

    var pageState : Int = 0
    lateinit var transactionAdapter : RecentTransactionAdapter
    var currentBalance : String = "0"

    fun makeRequest(): LiveData<AppResource<CryptoData>> {
        val repo = CryptoRepo()
        return if (pageState == 0) repo.requestEmptyState() else repo.requestValueState()
    }



}
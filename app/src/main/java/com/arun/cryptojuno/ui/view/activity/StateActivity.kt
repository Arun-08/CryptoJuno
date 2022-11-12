package com.arun.cryptojuno.ui.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import com.arun.cryptojuno.data.model.AllTransaction
import com.arun.cryptojuno.data.model.CryptoHolding
import com.arun.cryptojuno.databinding.StateActivityBinding
import com.arun.cryptojuno.ui.view.adapter.CryptoAccountAdapter
import com.arun.cryptojuno.ui.view.adapter.CryptoHoldingAdapter
import com.arun.cryptojuno.ui.view.adapter.CurrentPriceAdapter
import com.arun.cryptojuno.ui.view.adapter.RecentTransactionAdapter
import com.arun.cryptojuno.ui.view.interfaces.BuyCoin
import com.arun.cryptojuno.ui.viewmodel.CryptoViewModel
import com.arun.cryptojuno.utils.Status

class StateActivity : AppCompatActivity(), BuyCoin {

    private lateinit var binding : StateActivityBinding
    private lateinit var cryptoViewModel : CryptoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StateActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cryptoViewModel = ViewModelProvider(this)[CryptoViewModel::class.java]
        cryptoViewModel.pageState = intent.getIntExtra("pageState",0)
        loadUI()
    }

    private fun loadUI(){
      cryptoViewModel.makeRequest().observe(this) {
          when (it.status) {
              Status.LOADING -> changeViewState(it.status)
              Status.SUCCESS -> {
                  cryptoViewModel.currentBalance = it.data!!.cryptoBalance.currentBalInUsd
                  val accountAdapter = CryptoAccountAdapter(it.data!!.cryptoBalance,cryptoViewModel.pageState)
                  val holderAdapter = CryptoHoldingAdapter(it.data!!.yourCryptoHoldings,cryptoViewModel.pageState,this)
                  holderAdapter.mActivity = this
                  cryptoViewModel.transactionAdapter = RecentTransactionAdapter(it.data!!.allTransactions,cryptoViewModel.pageState)
                  val pricesAdapter = CurrentPriceAdapter(it.data!!.cryptoPrices)
                  val concatAdapter = ConcatAdapter(accountAdapter,holderAdapter,cryptoViewModel.transactionAdapter,pricesAdapter)
                  binding.rvList.adapter = concatAdapter
                  changeViewState(it.status)
              }
              Status.FAILURE -> changeViewState(it.status)
          }
      }
    }

    private fun changeViewState(status : Status){
        binding.progress.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.rvList.visibility = View.GONE
        when(status){
            Status.LOADING -> binding.progress.visibility = View.VISIBLE
            Status.SUCCESS -> binding.rvList.visibility = View.VISIBLE
            Status.FAILURE -> binding.tvError.visibility = View.VISIBLE
        }
    }

    override fun onClick(holdingItem : CryptoHolding) {
        val curBal : Float = cryptoViewModel.currentBalance.toFloat()
        cryptoViewModel.currentBalance = (curBal + holdingItem.currentBalInToken.toFloat()).toString()
        val transaction = AllTransaction("",holdingItem.title,"1 Minutes ago",cryptoViewModel.currentBalance,holdingItem.currentBalInToken)
        cryptoViewModel.transactionAdapter.addTransaction(transaction)
    }

}
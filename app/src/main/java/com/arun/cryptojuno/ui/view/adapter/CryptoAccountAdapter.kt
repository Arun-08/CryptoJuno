package com.arun.cryptojuno.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arun.cryptojuno.R
import com.arun.cryptojuno.data.model.CryptoBalance
import com.arun.cryptojuno.databinding.CryptoAccountBinding
import com.bumptech.glide.Glide

class CryptoAccountAdapter(private val cryptoAccount : CryptoBalance, private val pageState : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_account,parent,false)
        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AccountViewHolder).setDetails()
    }

    override fun getItemCount(): Int = 1


    inner class AccountViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding : CryptoAccountBinding = DataBindingUtil.bind(view)!!

        fun setDetails(){
            binding.apply {
                tvAccName.text = cryptoAccount.title
                tvCryptos.text = cryptoAccount.subTitle
                tvCurrentUsd.text =  cryptoAccount.currentBalInUsd
            }
            Glide.with(binding.root.context).load(R.mipmap.ic_launcher).into(binding.ivLogo)
            if(pageState == 0){
                binding.llValueState.visibility = View.GONE
                binding.tvDeposit.visibility = View.VISIBLE
            } else {
                binding.llValueState.visibility = View.VISIBLE
                binding.tvDeposit.visibility = View.GONE
            }

        }

    }

}
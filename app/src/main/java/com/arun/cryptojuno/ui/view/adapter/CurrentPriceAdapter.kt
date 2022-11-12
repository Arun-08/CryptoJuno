package com.arun.cryptojuno.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.cryptojuno.R
import com.arun.cryptojuno.data.model.CryptoPrices
import com.arun.cryptojuno.databinding.CurrentPricesBinding
import com.arun.cryptojuno.databinding.CurrentPricesItemBinding
import com.arun.cryptojuno.utils.ImageLoader

class CurrentPriceAdapter(private val pricesList : ArrayList<CryptoPrices>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.current_prices,parent,false)
        return PricesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PricesViewHolder).setDetails()
    }

    override fun getItemCount(): Int = 1


    private inner class PricesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CurrentPricesBinding.bind(view)

        fun setDetails(){
            val adapter = PriceItemAdapter()
            binding.rvTransactions.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)
            binding.rvTransactions.adapter = adapter
        }

        private inner class PriceItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): RecyclerView.ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.current_prices_item,parent,false)
                return PriceItemViewHolder(view)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder as PriceItemViewHolder).setItemDetails(pricesList[position])
            }

            override fun getItemCount(): Int = pricesList.size

            private inner class PriceItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
                private val itemBinding = CurrentPricesItemBinding.bind(view)

                fun setItemDetails(data : CryptoPrices){
                    itemBinding.apply {
                        tvCoinName.text = data.title
                        tvCoin.text = data.currentBalInUsd
                    }
                    ImageLoader().loadImage(itemBinding.ivLogo,data.logo)
                }
            }


        }


    }
}
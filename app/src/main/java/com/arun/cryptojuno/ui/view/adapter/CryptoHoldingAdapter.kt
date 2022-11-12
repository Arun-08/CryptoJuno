package com.arun.cryptojuno.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.cryptojuno.R
import com.arun.cryptojuno.data.model.CryptoHolding
import com.arun.cryptojuno.databinding.CryptoHolderBinding
import com.arun.cryptojuno.databinding.CryptoHolderItemBinding
import com.arun.cryptojuno.ui.view.interfaces.BuyCoin
import com.arun.cryptojuno.utils.ImageLoader

class CryptoHoldingAdapter(private val holderList : ArrayList<CryptoHolding>, private val pageState : Int, private val listener : BuyCoin) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var mActivity : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_holder,parent,false)
        return HoldingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HoldingViewHolder).setDetails()
    }

    override fun getItemCount(): Int = 1

    inner class HoldingViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val binding : CryptoHolderBinding = CryptoHolderBinding.bind(view)

        fun setDetails(){
            val itemAdapter = HolderItemAdapter()
            binding.rvCryptoHolder.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL,false)
            binding.rvCryptoHolder.adapter = itemAdapter
        }

        private inner class HolderItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): RecyclerView.ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_holder_item,parent,false)
                return ItemViewHolder(view)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder as ItemViewHolder).setItemDetails(holderList[position])
            }

            override fun getItemCount(): Int = holderList.size

            inner class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
                private val itemBinding : CryptoHolderItemBinding = DataBindingUtil.bind(view)!!

                fun setItemDetails(data : CryptoHolding){
                    itemBinding.apply {
                        tvOrgName.text = data.title
                        tvBalToken.text = data.currentBalInToken
                        tvCurrentUsd.text = data.currentBalInUsd
                    }
                    ImageLoader().loadImage(itemBinding.ivLogo,data.logo)
                    itemBinding.llButton.visibility = View.GONE
                    itemBinding.llValueState.visibility = View.GONE
                    itemBinding.tvBuy.setOnClickListener {
                        listener.onClick(data)
                    }
                    if(pageState == 0)
                        itemBinding.llButton.visibility = View.VISIBLE
                    else
                        itemBinding.llValueState.visibility = View.VISIBLE
                }

            }

        }

    }


}
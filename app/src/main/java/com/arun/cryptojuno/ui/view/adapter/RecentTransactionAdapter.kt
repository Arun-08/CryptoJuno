package com.arun.cryptojuno.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.cryptojuno.R
import com.arun.cryptojuno.data.model.AllTransaction
import com.arun.cryptojuno.databinding.RecentTransactionBinding
import com.arun.cryptojuno.databinding.RecentTransactionItemBinding
import com.arun.cryptojuno.utils.ImageLoader

class RecentTransactionAdapter(private val transactionList : ArrayList<AllTransaction>, private val pageState : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_transaction_item,parent)
        return TransactionHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TransactionHolder).setDetails()
    }

    override fun getItemCount(): Int = 1

    private inner class TransactionHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = RecentTransactionBinding.bind(view)

        fun setDetails(){
            val itemAdapter = TransactionItemAdapter()
            binding.rvTransactions.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL,false)
            binding.rvTransactions.adapter = itemAdapter
        }

        private inner class TransactionItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): RecyclerView.ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_transaction_item,parent)
                return TransactionItemHolder(view)
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder as TransactionItemHolder).setItemDetails(transactionList[position])
            }

            override fun getItemCount(): Int = transactionList.size

            private inner class TransactionItemHolder(view: View) : RecyclerView.ViewHolder(view) {
                private val itemBinding = RecentTransactionItemBinding.bind(view)

                fun setItemDetails(data: AllTransaction){
                    itemBinding.apply {
                        tvOrgName.text = data.title
                        tvDuration.text = data.txnTime
                        tvAmount.text = data.txnAmount
                        tvSubAmount.text = data.txnSubAmount
                    }
                    ImageLoader().loadImage(itemBinding.ivLogo,data.txnLogo)
                }
            }

        }

    }




}
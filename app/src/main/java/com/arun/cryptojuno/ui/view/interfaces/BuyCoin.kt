package com.arun.cryptojuno.ui.view.interfaces

import com.arun.cryptojuno.data.model.CryptoHolding

interface BuyCoin {
    fun onClick(holdingItem : CryptoHolding)
}
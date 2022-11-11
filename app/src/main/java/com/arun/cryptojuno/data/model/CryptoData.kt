package com.arun.cryptojuno.data.model

import com.google.gson.annotations.SerializedName

data class CryptoData(
    @SerializedName("crypto_balance")
    var cryptoBalance : CryptoBalance,
    @SerializedName("your_crypto_holdings")
    var yourCryptoHoldings : ArrayList<CryptoHolding>,
    @SerializedName("crypto_prices")
    var cryptoPrices : ArrayList<CryptoPrices>,
    @SerializedName("all_transactions")
    var allTransactions : ArrayList<AllTransaction>
)

data class CryptoBalance(
    @SerializedName("title")
    var title : String,
    @SerializedName("subtitle")
    var subTitle : String,
    @SerializedName("current_bal_in_usd")
    var currentBalInUsd : String
)

data class CryptoHolding(
    @SerializedName("logo")
    var logo : String,
    @SerializedName("title")
    var title : String,
    @SerializedName("current_bal_in_token")
    var currentBalInToken : String,
    @SerializedName("current_bal_in_usd")
    var currentBalInUsd : String
)

data class CryptoPrices(
    @SerializedName("logo")
    var logo : String,
    @SerializedName("title")
    var title : String,
    @SerializedName("current_bal_in_usd")
    var currentBalInUsd : String
)

data class AllTransaction(
    @SerializedName("txn_logo")
    var txnLogo: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("txn_time")
    var txnTime: String,
    @SerializedName("txn_amount")
    var txnAmount: String,
    @SerializedName("txn_sub_amount")
    var txnSubAmount: String
)
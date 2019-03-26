package com.example.ml_challenge.model

import com.example.ml_challenge.data.TransactionsOfDate

interface ITransactionModel {
    fun getTransactionsForAccount(accountId : UInt) : List<TransactionsOfDate>?
}
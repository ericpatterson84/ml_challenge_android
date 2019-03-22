package com.example.ml_challenge.model

import com.example.ml_challenge.data.Transaction

interface ITransactionModel {
    fun getTransactionsForAccount(accountId : UInt) : List<Transaction>?
}
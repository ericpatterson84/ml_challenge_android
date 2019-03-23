package com.example.ml_challenge.model

import android.content.Context
import com.example.ml_challenge.data.TransactionsOfDate

interface ITransactionModel {
    fun populateModel(context: Context)
    fun getTransactionsForAccount(accountId : UInt) : List<TransactionsOfDate>?
}
package com.example.ml_challenge.model

import android.content.Context
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Transaction
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader

class JsonTransactionsModel : ITransactionModel {

    private var transactionMap = emptyMap<UInt, List<Transaction>>()

    fun populateModel(context: Context) {
        if(transactionMap.isEmpty()) {
            val inputStream = context.resources.openRawResource(R.raw.account_transactions)
            val transactionJsonStr = inputStream.bufferedReader().use(BufferedReader::readText)

            transactionJsonStr?.let {
                val transactionJsonArray = JSONArray(it)
                val parser = TransactionParser()
                transactionMap = parser.getTransactionsFromJson(transactionJsonArray)
            }
        }
    }

    override fun getTransactionsForAccount(accountId: UInt): List<Transaction>? {
        return transactionMap[accountId]
    }
}
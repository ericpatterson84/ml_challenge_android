package com.example.ml_challenge.model

import android.content.Context
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Transaction
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader

class JsonTransactionsModel : ITransactionModel {

    private var transactionMap : Map<UInt, List<Transaction>>? = null

    fun populateModel(context: Context) {
        if(transactionMap == null) {
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
        transactionMap?.let{
            return transactionMap!![accountId]
        }

        return null
    }
}
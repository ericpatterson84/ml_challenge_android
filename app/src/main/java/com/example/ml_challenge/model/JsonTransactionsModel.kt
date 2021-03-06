package com.example.ml_challenge.model

import android.content.Context
import com.example.ml_challenge.data.TransactionsOfDate
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader

class JsonTransactionsModel : ITransactionModel {

    private var transactionMap = emptyMap<UInt, List<TransactionsOfDate>>()

    fun populateModel(context: Context?, resId: Int?) {
        if(transactionMap.isEmpty()) {
            val inputStream = context?.resources?.openRawResource(resId!!)
            val transactionJsonStr = inputStream!!.bufferedReader().use(BufferedReader::readText)

            val transactionJsonArray = JSONArray(transactionJsonStr)
            val parser = TransactionParser()
            transactionMap = parser.getTransactionsFromJson(transactionJsonArray)
        }
    }

    override fun getTransactionsForAccount(accountId: UInt): List<TransactionsOfDate>? {
        return transactionMap[accountId]
    }
}
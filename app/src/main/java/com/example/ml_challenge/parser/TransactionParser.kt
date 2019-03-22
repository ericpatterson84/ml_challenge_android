package com.example.ml_challenge.parser

import com.example.ml_challenge.data.Transaction
import org.json.JSONArray
import org.json.JSONObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TransactionParser {

    fun getTransactionsFromJson(transactionArray: JSONArray) : MutableList<Transaction> {
        val transactions = mutableListOf<Transaction>()

        for(i in 0..(transactionArray.length() - 1)) {
            val dateObj = transactionArray.getJSONObject(i)
            dateObj?.let {
                if(it.has("activity")) {
                    val activityArray = it.getJSONArray("activity")
                    activityArray?.let {activityArray ->
                        for(i in 0..(activityArray.length() - 1)) {
                            val activityObj = activityArray.getJSONObject(i)
                            transactions.add(parseTransactionObject(activityObj))
                        }
                    }
                }
            }
        }

        return transactions
    }

    fun parseTransactionObject(transactionObj: JSONObject) : Transaction {
//        {
//            "id": 158,
//            "date": "2017-11-30",
//            "description": "Interest Posting",
//            "withdrawal_amount": 56.66,
//            "balance": 101477.2,
//            "transaction_uid": 7980194686
//        },
        val id = transactionObj.getInt("id")
        val dateStr = transactionObj.getString("date")
        val date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE)
        val desc = transactionObj.getString("description")

        var amount = 0.0
        if(transactionObj.has("withdrawal_amount")) {
            amount = transactionObj.getDouble("withdrawal_amount") * -1.0
        } else if(transactionObj.has("deposit_amount")) {
            amount = transactionObj.getDouble("deposit_amount")
        }

        val balance = transactionObj.getDouble("balance")
        val uid = transactionObj.getLong("transaction_uid")

        return Transaction(id, date, desc, amount, balance, uid)
    }
}
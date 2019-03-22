package com.example.ml_challenge

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ml_challenge.parser.AccountParser
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val accountsJsonStr = readRawTextFile(baseContext, R.raw.list_of_accounts)

        accountsJsonStr?.let {
            val accountsJsonArray = JSONArray(it)
            val ap = AccountParser()
            val accounts = ap.getAccountsFromJson(accountsJsonArray)

            println("size: " + accounts.size)
            for(a in accounts) {
                println("account: " + a.id + " " + a.number + " " +  a.name + " " + a.balance)
            }
        }

        val transactionJsonStr = readRawTextFile(baseContext, R.raw.chequing_account)

        transactionJsonStr?.let {
            val transactionJsonArray = JSONArray(it)
            val tp = TransactionParser()
            val transactions = tp.getTransactionsFromJson(transactionJsonArray)

            println("size: " + transactions.size)
            for(t in transactions) {
                println("transaction: " + t.id + " " + t.amount + " " +  t.balance + " " + t.date + " " + t.description + " " + t.uid)
            }
        }
    }

    private fun readRawTextFile(ctx: Context, resId: Int): String? {
        val inputStream = ctx.resources.openRawResource(resId)
        return inputStream.bufferedReader().use(BufferedReader::readText)
    }
}

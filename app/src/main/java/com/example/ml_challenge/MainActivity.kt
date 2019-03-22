package com.example.ml_challenge

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.list.AccountsFragment
import com.example.ml_challenge.model.JsonAccountsModel
import com.example.ml_challenge.model.JsonTransactionsModel
import com.example.ml_challenge.parser.AccountParser
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader


class MainActivity : AppCompatActivity(), AccountsFragment.OnListFragmentInteractionListener {

    var accountsModel: JsonAccountsModel? = null
    var transactionsModel: JsonTransactionsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            if(accountsModel == null) {
                accountsModel = JsonAccountsModel()
                accountsModel!!.populateModel(baseContext)
            }
            val accountsFragment = AccountsFragment()
            accountsFragment.setModel(accountsModel!!)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, accountsFragment, "accountsList")
                .commit()
        }

//        val accountsJsonStr = readRawTextFile(baseContext, R.raw.list_of_accounts)
//
//        accountsJsonStr?.let {
//            val accountsJsonArray = JSONArray(it)
//            val ap = AccountParser()
//            val accounts = ap.getAccountsFromJson(accountsJsonArray)
//
//            println("size: " + accounts.size)
//            for(a in accounts) {
//                println("account: " + a.id + " " + a.number + " " +  a.name + " " + a.balance)
//            }
//        }
//
//        val transactionJsonStr = readRawTextFile(baseContext, R.raw.chequing_account)
//
//        transactionJsonStr?.let {
//            val transactionJsonArray = JSONArray(it)
//            val tp = TransactionParser()
//            val transactions = tp.getTransactionsFromJson(transactionJsonArray)
//
//            println("size: " + transactions.size)
//            for(t in transactions) {
//                println("transaction: " + t.id + " " + t.amount + " " +  t.balance + " " + t.date + " " + t.description + " " + t.uid)
//            }
//        }
    }

    override fun onListFragmentInteraction(item: Account?) {
        item?.let {
            println("Account ID: " + item.id)
        }
    }
}

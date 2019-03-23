package com.example.ml_challenge

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.list.AccountsFragment
import com.example.ml_challenge.list.TransactionsFragment
import com.example.ml_challenge.model.JsonAccountsModel
import com.example.ml_challenge.model.JsonTransactionsModel
import com.example.ml_challenge.parser.AccountParser
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    var accountsModel: JsonAccountsModel? = null
//    var transactionsModel: JsonTransactionsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.let {
            it.hide()
        }

        if (savedInstanceState == null) {
            // TODO: Logic for Open button visibility
        }

        openBtn.setOnClickListener{
//            if(accountsModel == null) {
//                accountsModel = JsonAccountsModel()
//            }
            showAccountsList()
        }
    }

    private fun showAccountsList() {
//        accountsModel?.let {
//            it.populateModel(baseContext)
//            val accountsFragment = AccountsFragment()
//            accountsFragment.setModel(it)
//
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.root_layout, accountsFragment, "accountsList")
//                .commit()
//        }

        val intent = Intent(this, AccountsActivity::class.java)
        // create the transition animation - the images in the layouts
        // of both activities are defined with android:transitionName="robot"
//        val options = ActivityOptions
//            .makeSceneTransitionAnimation(this, androidRobotView, "robot")
        // start the new activity
//        startActivity(intent, options.toBundle())
        startActivity(intent)
    }

    private fun showTransactionsList(accountId: UInt) {
//        transactionsModel?.let {
//            it.populateModel(baseContext)
//            val transactionsFragment = TransactionsFragment.newInstance(accountId)
//            transactionsFragment.model = it
//
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.root_layout, transactionsFragment, "transactionsList")
//                .commit()
//        }
    }


}

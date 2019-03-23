package com.example.ml_challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ml_challenge.list.TransactionsFragment
import com.example.ml_challenge.model.JsonTransactionsModel

class TransactionsActivity : AppCompatActivity() {

    private var transactionsModel: JsonTransactionsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)
        if (savedInstanceState == null) {
            val tf = TransactionsFragment.newInstance(0U)
            if(transactionsModel == null) {
                transactionsModel = JsonTransactionsModel()
            }

            transactionsModel?.let {
                it.populateModel(baseContext)
                tf.model = it
                supportFragmentManager.beginTransaction()
                    .replace(R.id.transactionsFragment, tf, "transactionList")
                    .commitNow()
            }
        }
    }

}

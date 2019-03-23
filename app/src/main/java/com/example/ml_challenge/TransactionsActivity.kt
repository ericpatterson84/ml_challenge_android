package com.example.ml_challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ml_challenge.list.TransactionsFragment
import com.example.ml_challenge.model.ITransactionModel
import com.example.ml_challenge.model.JsonTransactionsModel
import kotlinx.android.synthetic.main.activity_transactions.*

class TransactionsActivity : AppCompatActivity() {

    private var transactionsModel: ITransactionModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        intent?.let {
            val accountId = it.getIntExtra(AccountsActivity.ARG_ACCOUNT_ID, 0)
            val accountName = it.getStringExtra(AccountsActivity.ARG_ACCOUNT_NAME)

            supportActionBar?.let { bar ->
                bar.title = accountName
            }

            val tf = TransactionsFragment.newInstance(accountId.toUInt())
            if(transactionsModel == null) {
                transactionsModel = JsonTransactionsModel()
            }

            transactionsModel?.let { tm ->
                tm.populateModel(baseContext)
                tf.model = tm
                supportFragmentManager.beginTransaction()
                    .replace(R.id.transactionsLayout, tf, "transactionList")
                    .commitNow()
            }
        }
    }
}

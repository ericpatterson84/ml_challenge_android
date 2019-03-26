package com.example.ml_challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ml_challenge.list.TransactionsFragment
import com.example.ml_challenge.model.IDataModelListener
import com.example.ml_challenge.model.JsonTransactionsModel
import com.example.ml_challenge.model.ReadTransactionsTask
import com.example.ml_challenge.util.FormatUtils
import kotlinx.android.synthetic.main.activity_transactions.*
import java.lang.ref.WeakReference

class TransactionsActivity : AppCompatActivity(), IDataModelListener {

    private var transactionsModel: JsonTransactionsModel? = null

    private var accountId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        intent?.let {
            accountId = it.getIntExtra(AccountsActivity.ARG_ACCOUNT_ID, 0)
            val accountName = it.getStringExtra(AccountsActivity.ARG_ACCOUNT_NAME)
            val accountBalance = it.getDoubleExtra(AccountsActivity.ARG_ACCOUNT_BALANCE, 0.0)

            supportActionBar?.let { bar ->
                bar.title = getString(R.string.accounts)
            }

            account_name_large.text = accountName
            account_balance_large.text = FormatUtils.formattedAmountString(accountBalance)


            if(transactionsModel == null) {
                transactionsModel = JsonTransactionsModel()
            }

            // Read transactions on background thread. This could simulate fetching from a server with high latency
            ReadTransactionsTask(WeakReference(baseContext), transactionsModel, this)
                .execute(R.raw.account_transactions)
        }
    }

    override fun populateModelComplete(result: Boolean) {
        if(result) {
            val fragment = TransactionsFragment.newInstance(accountId.toUInt())
            fragment.model = transactionsModel
            supportFragmentManager.beginTransaction()
                .replace(R.id.transactionsLayout, fragment, "transactionList")
                .commitNow()
        }
    }
}

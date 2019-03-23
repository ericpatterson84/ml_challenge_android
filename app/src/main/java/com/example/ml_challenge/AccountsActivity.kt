package com.example.ml_challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ml_challenge.list.AccountsFragment
import com.example.ml_challenge.model.JsonAccountsModel

class AccountsActivity : AppCompatActivity() {

    var accountsModel: JsonAccountsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)
        if (savedInstanceState == null) {

            accountsModel = JsonAccountsModel()
            accountsModel?.let {
                it.populateModel(baseContext)
                val accountsFragment = AccountsFragment()
                accountsFragment.setModel(it)

                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.accountsFragment, accountsFragment, "accountsList")
                    .commit()
            }
        }
    }
}

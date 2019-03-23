package com.example.ml_challenge

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.list.AccountsFragment
import com.example.ml_challenge.model.JsonAccountsModel
import kotlinx.android.synthetic.main.activity_accounts.*

class AccountsActivity : AppCompatActivity(), AccountsFragment.OnAccountListInteractionListener{

    companion object {
        const val ARG_ACCOUNT_ID = "account-id"
        const val ARG_ACCOUNT_NAME = "account-name"
        const val ARG_ACCOUNT_BALANCE = "account-balance"
    }

//    var accountsModel: JsonAccountsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)

        supportActionBar?.let {
            it.title = getString(R.string.accounts)

        }

        if (savedInstanceState == null) {

//            accountsModel = JsonAccountsModel()
//            accountsModel?.let {
//                it.populateModel(baseContext)
//                accountsFragment.model = it
//
//                supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.accountsFragment, accountsFragment, "accountsList")
//                    .commit()
//            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.accounts_menu, menu)
        return true
    }

    override fun onAccountListInteraction(item: Account?) {
        item?.let {
            println("Account ID: " + it.id)

            // create the transition animation - the images in the layouts
            // of both activities are defined with android:transitionName="robot"
//        val options = ActivityOptions
//            .makeSceneTransitionAnimation(this, androidRobotView, "robot")
            // start the new activity

            val intent = Intent(this, TransactionsActivity::class.java)
//            val bundle = Bundle()
//            bundle.putInt(ARG_ACCOUNT_ID, it.id.toInt())

            intent.putExtra(ARG_ACCOUNT_ID, it.id.toInt())
            intent.putExtra(ARG_ACCOUNT_NAME, it.name)
            intent.putExtra(ARG_ACCOUNT_BALANCE, it.balance)

            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_quit -> {
            // Clear app opened flag
            // Quit app
            println("QUIT")
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}

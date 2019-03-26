package com.example.ml_challenge

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.list.AccountsFragment

class AccountsActivity : AppCompatActivity(), AccountsFragment.OnAccountListInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)

        supportActionBar?.let {
            it.title = getString(R.string.app_name)

        }
    }

    override fun onResume() {
        super.onResume()

        // Clear the app quit flag
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(baseContext)
        sharedPref.edit()
            .putBoolean(getString(R.string.quit_preference_key), false)
            .apply()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.accounts_menu, menu)
        return true
    }

    override fun onAccountListInteraction(item: Account?) {
        item?.let {
            val intent = Intent(this, TransactionsActivity::class.java)

            // Pass account details to transactions activity
            intent.putExtra(ARG_ACCOUNT_ID, it.id.toInt())
            intent.putExtra(ARG_ACCOUNT_NAME, it.name)
            intent.putExtra(ARG_ACCOUNT_BALANCE, it.balance)

            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_quit -> {
            // Set the app quit flag
            val sharedPref = PreferenceManager.getDefaultSharedPreferences(baseContext)
            sharedPref.edit()
                .putBoolean(getString(R.string.quit_preference_key), true)
                .apply()
            //Cleanly exit the app
            finishAndRemoveTask()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val ARG_ACCOUNT_ID = "account-id"
        const val ARG_ACCOUNT_NAME = "account-name"
        const val ARG_ACCOUNT_BALANCE = "account-balance"
    }
}

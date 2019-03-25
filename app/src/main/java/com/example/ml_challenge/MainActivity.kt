package com.example.ml_challenge

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getDefaultSharedPreferences(baseContext) ?: return
        val userHasQuit = sharedPref.getBoolean(getString(R.string.quit_preference_key), true)

        if(!userHasQuit) {
            // User didn't quit previous session, show Accounts immediately
            showAccountsList()
            return
        }

        setContentView(R.layout.activity_main)
        supportActionBar?.let {
            it.hide()
        }

        openBtn.setOnClickListener{
            showAccountsList()
        }
    }

    private fun showAccountsList() {
        val intent = Intent(this, AccountsActivity::class.java)
        startActivity(intent)
        // Finish the activity to ensure the user doesn't go back to splash screen when Back is pressed from Accounts
        finish()
    }
}

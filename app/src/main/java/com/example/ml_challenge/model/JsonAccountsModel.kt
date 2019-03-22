package com.example.ml_challenge.model

import android.content.Context
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.parser.AccountParser
import org.json.JSONArray
import java.io.BufferedReader

class JsonAccountsModel : IAccountsModel {

    private var accountList : List<Account>? = null

    fun populateModel(context: Context) {
        if(accountList == null) {
            val inputStream = context.resources.openRawResource(R.raw.list_of_accounts)
            val accountsJsonStr = inputStream.bufferedReader().use(BufferedReader::readText)

            accountsJsonStr?.let {
                val accountsJsonArray = JSONArray(it)
                val parser = AccountParser()
                accountList = parser.getAccountsFromJson(accountsJsonArray)
            }
        }
    }

    override fun getAllAccounts(): List<Account>? {
        return accountList
    }
}
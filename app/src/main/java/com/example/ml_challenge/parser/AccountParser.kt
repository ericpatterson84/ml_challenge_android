package com.example.ml_challenge.parser

import com.example.ml_challenge.data.Account
import org.json.JSONArray
import org.json.JSONObject

class AccountParser {

    fun getAccountsFromJson(accountArray: JSONArray) : List<Account> {
        val accounts = mutableListOf<Account>()

        for(i in 0..(accountArray.length() - 1)) {
            val accountObj = accountArray.getJSONObject(i)
            accounts.add(parseAccountObject(accountObj))
        }

        return accounts
    }

    fun parseAccountObject(accountObj: JSONObject) : Account {
        val id = accountObj.getInt("id")
        val name = accountObj.getString("display_name")
        val num = accountObj.getString("account_number")
        val balance = accountObj.getDouble("balance")

        return Account(id, name, num, balance)
    }
}
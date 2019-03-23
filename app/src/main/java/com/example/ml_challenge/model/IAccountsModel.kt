package com.example.ml_challenge.model

import android.content.Context
import com.example.ml_challenge.data.Account

interface IAccountsModel {
    fun populateModel(context: Context)
    fun getAllAccounts() : List<Account>
}
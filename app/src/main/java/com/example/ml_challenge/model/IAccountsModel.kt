package com.example.ml_challenge.model

import com.example.ml_challenge.data.Account

interface IAccountsModel {
    fun getAllAccounts() : List<Account>
}
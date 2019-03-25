package com.example.ml_challenge.data

import java.time.LocalDate

class TransactionsOfDate(val date: LocalDate) {

    var transactions = listOf<Transaction>()
}
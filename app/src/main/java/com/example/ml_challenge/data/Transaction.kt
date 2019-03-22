package com.example.ml_challenge.data

import java.time.LocalDate
import java.util.*

//{
//    "id": 159,
//    "date": "2017-11-30",
//    "description": "Interest Posting",
//    "withdrawal_amount": 212.47,
//    "balance": 101264.73,
//    "transaction_uid": 6117556574
//}

class Transaction(val id: Int,
                  val date: LocalDate,
                  val description: String,
                  val amount: Double,
                  val balance: Double,
                  val uid: Long) {
}
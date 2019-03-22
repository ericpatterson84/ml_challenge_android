package com.example.ml_challenge

import com.example.ml_challenge.data.Account
import com.example.ml_challenge.parser.AccountParser
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test

class AccountParserTest {

    @Test
    fun parseAccountObject_allFields() {
//        {
//            "id":10,
//            "display_name": "Chequing Account",
//            "account_number": "3157419",
//            "balance": 102406.86
//        }

        // Arrange
        var obj = JSONObject()
        obj.put("id", 10)
        obj.put("display_name", "Chequing Account")
        obj.put("account_number", "3157419")
        obj.put("balance", 102406.86)

        // Act
        val ap = AccountParser()
        val account : Account = ap.parseAccountObject(obj)

        // Assert
        Assert.assertEquals(10, account.id)
        Assert.assertEquals("Chequing Account", account.name)
        Assert.assertEquals("3157419", account.number)
        Assert.assertEquals(102406.86, account.balance)
    }
}
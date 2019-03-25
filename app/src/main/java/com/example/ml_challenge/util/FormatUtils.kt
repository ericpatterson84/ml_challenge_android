package com.example.ml_challenge.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class FormatUtils {
    companion object {

        fun formattedAmountString(amount: Double, insertCommas: Boolean = true) : String {
            var tmp = amount
            var amountStr = ""
            if(amount < 0) {
                amountStr = "-"
                tmp *= -1.0
            }

            amountStr += "$$tmp"
            if(insertCommas) {
                return insertThousandCommas(amountStr)
            }
            return amountStr
        }

        private fun insertThousandCommas(amountStr: String) : String {
            val decimalIdx = amountStr.lastIndexOf('.')
            val builder = StringBuilder(amountStr)
            var curIdx : Int
            if(decimalIdx != -1) {
                curIdx = decimalIdx
            } else {
                curIdx = amountStr.length - 1
            }

            curIdx -= 3
            while(curIdx > 0 && builder[curIdx-1] >= '0' && builder[curIdx-1] <= '9') {
                builder.insert(curIdx, ',')
                curIdx -= 3
            }

            return builder.toString()
        }

        fun formattedDateString(date: LocalDate) : String {
            val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
            return date.format(formatter)
        }
    }
}
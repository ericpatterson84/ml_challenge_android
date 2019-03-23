package com.example.ml_challenge.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.data.Transaction

import com.example.ml_challenge.list.dummy.DummyContent
import com.example.ml_challenge.list.dummy.DummyContent.DummyItem
import com.example.ml_challenge.model.ITransactionModel
import com.example.ml_challenge.parser.AccountParser
import com.example.ml_challenge.parser.TransactionParser
import org.json.JSONArray
import java.io.BufferedReader

/**
 * A fragment representing a list of Items.
 */
class TransactionsFragment : Fragment() {

    private var accountId = 0U

    var model : ITransactionModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            accountId = it.getInt(ARG_ACCOUNT_ID).toUInt()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transactions_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
//                adapter = TransactionsRecyclerViewAdapter(DummyContent.ITEMS, listener)
                model?.let {
                    val transactions = it.getTransactionsForAccount(accountId)
                    transactions?.let { t ->
                        adapter = TransactionsRecyclerViewAdapter(t)
                    }
                }
            }
        }
        return view
    }

    companion object {

        private const val ARG_ACCOUNT_ID = "account-id"

        @JvmStatic
        fun newInstance(accountId: UInt) =
            TransactionsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ACCOUNT_ID, accountId.toInt())
                }
            }
    }
}

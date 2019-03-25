package com.example.ml_challenge.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ml_challenge.AccountsActivity
import com.example.ml_challenge.R
import com.example.ml_challenge.data.TransactionsOfDate
import com.example.ml_challenge.model.ITransactionModel
import com.example.ml_challenge.util.FormatUtils
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter


/**
 * A fragment representing a list of Items.
 */
class TransactionsFragment : Fragment() {

    private var accountId = 0U

    var model : ITransactionModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            accountId = it.getInt(AccountsActivity.ARG_ACCOUNT_ID).toUInt()
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
                model?.let {
                    val transactions : List<TransactionsOfDate>? = it.getTransactionsForAccount(accountId)
                    transactions?.let { t ->
                        val sectionAdapter = SectionedRecyclerViewAdapter()
                        for(tod in t) {
                            val formattedDateStr = FormatUtils.formattedDateString(tod.date)
                            sectionAdapter.addSection(HeaderRecyclerViewSection(formattedDateStr, tod.transactions))
                        }
                        adapter = sectionAdapter
                    }
                }
            }
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(accountId: UInt) =
            TransactionsFragment().apply {
                arguments = Bundle().apply {
                    putInt(AccountsActivity.ARG_ACCOUNT_ID, accountId.toInt())
                }
            }
    }
}

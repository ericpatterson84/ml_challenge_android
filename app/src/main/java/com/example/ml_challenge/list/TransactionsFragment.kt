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

            //Set account name and balance from args
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
                    val transactions : List<TransactionsOfDate>? = it.getTransactionsForAccount(accountId)
                    transactions?.let { t ->
                        val sectionAdapter = SectionedRecyclerViewAdapter()
//                        adapter = TransactionsRecyclerViewAdapter(t)
                        for(tod in t) {
                            sectionAdapter.addSection(HeaderRecyclerViewSection(tod.date, tod.transactions))
                        }
                        adapter = sectionAdapter
                    }
                }
            }
        }
        return view

        // Inflate the layout for this fragment
//        val layout = inflater.inflate(com.example.ml_challenge.R.layout.fragment_transactions_listlist, container, false)
//
//        val sectionAdapter = SectionedRecyclerViewAdapter()
//        val tasks = Arrays.asList(resources.getStringArray(R.array.tasks))
//        val sectionHeader = layout.findViewById(R.id.recycler_view) as RecyclerView
//        val linearLayoutManager = LinearLayoutManager(activity!!.applicationContext)
//        sectionHeader.setLayoutManager(linearLayoutManager)
//        sectionHeader.setHasFixedSize(true)
//        sectionAdapter = SectionedRecyclerViewAdapter()
//        for (i in 0 until resources.getStringArray(R.array.tasks).size) {
//            val newSection = HeaderRecyclerViewSection(tasks.get(i), getDataTasks(i + 1))
//            sectionAdapter.addSection(newSection)
//        }
//        sectionHeader.setAdapter(sectionAdapter)
//
//        return layout
    }

    companion object {

        @JvmStatic
        fun newInstance(accountId: UInt, accountName: String, accountBalance: Double) =
            TransactionsFragment().apply {
                arguments = Bundle().apply {
                    putInt(AccountsActivity.ARG_ACCOUNT_ID, accountId.toInt())
                    putString(AccountsActivity.ARG_ACCOUNT_NAME, accountName)
                    putDouble(AccountsActivity.ARG_ACCOUNT_BALANCE, accountBalance)
                }
            }
    }
}

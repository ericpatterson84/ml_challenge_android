package com.example.ml_challenge.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Transaction
import com.example.ml_challenge.data.TransactionsOfDate


import com.example.ml_challenge.list.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_transactions.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 */
class TransactionsRecyclerViewAdapter(
    private val mValues: List<TransactionsOfDate>
) : RecyclerView.Adapter<TransactionsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_transactions, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mDescView.text = item.transactions[0].description
        holder.mAmountView.text = item.transactions[0].amount.toString()
    }

    override fun getItemCount(): Int {
        var itemCount = mValues.size

        for(tod in mValues) {
            itemCount += tod.transactions.size
        }

        return itemCount
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mDescView: TextView = mView.trans_desc
        val mAmountView: TextView = mView.trans_amount

        override fun toString(): String {
            return super.toString() + " '" + mDescView.text + "'"
        }
    }
}

package com.example.ml_challenge.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Transaction
import com.example.ml_challenge.util.FormatUtils
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection


class HeaderRecyclerViewSection(private val mTitle: String, private val mList: List<Transaction>) : StatelessSection(
    SectionParameters.Builder(R.layout.fragment_transactions)
        .headerResourceId(R.layout.fragment_date_header)
        .build()
) {
    override fun getContentItemsTotal(): Int {
        return mList.size
    }

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
        return ItemViewHolder(view)
    }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val iHolder = holder as ItemViewHolder
        iHolder.transDesc.text = mList[position].description
        iHolder.transAmount.text = FormatUtils.formattedAmountString(mList[position].amount)
    }

    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return HeaderViewHolder(view)
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
        val hHolder = holder as HeaderViewHolder?
        hHolder?.let {
            it.headerTitle.text = mTitle
        }
    }

    companion object {
        private val TAG = HeaderRecyclerViewSection::class.java.simpleName
    }
}
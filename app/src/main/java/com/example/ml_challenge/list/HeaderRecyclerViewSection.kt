package com.example.ml_challenge.list

import android.support.v7.widget.RecyclerView
import com.example.ml_challenge.R
import android.view.View
import com.example.ml_challenge.data.Transaction
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection


class HeaderRecyclerViewSection(private val title: String, private val list: List<Transaction>) : StatelessSection(
    SectionParameters.Builder(R.layout.fragment_transactions)
        .headerResourceId(R.layout.fragment_date_header)
        .build()
) {
    override fun getContentItemsTotal(): Int {
        return list.size
    }

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
        return ItemViewHolder(view)
    }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val iHolder = holder as ItemViewHolder
        iHolder.transDesc.text = list[position].description
        iHolder.transAmount.text = list[position].amount.toString()
    }

    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return HeaderViewHolder(view)
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
        val hHolder = holder as HeaderViewHolder?
        hHolder?.let {
            it.headerTitle.text = title
        }
    }

    companion object {
        private val TAG = HeaderRecyclerViewSection::class.java.simpleName
    }
}
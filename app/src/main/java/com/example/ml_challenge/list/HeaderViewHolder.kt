package com.example.ml_challenge.list

import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.ml_challenge.R


class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var headerTitle: TextView

    init {
        headerTitle = itemView.findViewById(R.id.transaction_date)
    }
}
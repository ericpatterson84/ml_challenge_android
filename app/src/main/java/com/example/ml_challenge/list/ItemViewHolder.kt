package com.example.ml_challenge.list

import com.example.ml_challenge.R
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View


class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var transDesc: TextView
    var transAmount: TextView

    init {
        transDesc = itemView.findViewById(R.id.trans_desc)
        transAmount = itemView.findViewById(R.id.trans_amount)
    }
}
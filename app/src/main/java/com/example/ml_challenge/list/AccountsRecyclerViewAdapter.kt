package com.example.ml_challenge.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.list.AccountsFragment.OnAccountListInteractionListener
import com.example.ml_challenge.util.FormatUtils
import kotlinx.android.synthetic.main.fragment_accounts.view.*

/**
 * [RecyclerView.Adapter] that can display a [Account] and makes a call to the
 * specified [OnAccountListInteractionListener].
 */
class AccountsRecyclerViewAdapter(
    private val mValues: List<Account>,
    private val mListener: OnAccountListInteractionListener?
) : RecyclerView.Adapter<AccountsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Account
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onAccountListInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_accounts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = '#' + item.number
        holder.mNameView.text = item.name
        holder.mBalanceView.text = FormatUtils.formattedAmountString(item.balance)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.account_num
        val mNameView: TextView = mView.account_name
        val mBalanceView: TextView = mView.account_balance

        override fun toString(): String {
            return super.toString() + " '" + mNameView.text + "'"
        }
    }
}

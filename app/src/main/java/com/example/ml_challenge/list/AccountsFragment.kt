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

import com.example.ml_challenge.list.dummy.DummyContent
import com.example.ml_challenge.list.dummy.DummyContent.DummyItem
import com.example.ml_challenge.model.IAccountsModel
import com.example.ml_challenge.parser.AccountParser
import org.json.JSONArray
import java.io.BufferedReader

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AccountsFragment.OnListFragmentInteractionListener] interface.
 */
class AccountsFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnAccountListInteractionListener? = null

//    private var accountList : List<Account>? = null

    private var accountsModel: IAccountsModel? = null

    fun setModel(model: IAccountsModel) {
        accountsModel = model
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        arguments?.let {
//            columnCount = it.getInt(ARG_COLUMN_COUNT)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_accounts_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
//                adapter = AccountsRecyclerViewAdapter(DummyContent.ITEMS, listener)
                accountsModel?.let {
                    adapter = AccountsRecyclerViewAdapter(it.getAllAccounts(), listener)
                }
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAccountListInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnAccountListInteractionListener {
        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: DummyItem?)
        fun onAccountListInteraction(item: Account?)
    }
}

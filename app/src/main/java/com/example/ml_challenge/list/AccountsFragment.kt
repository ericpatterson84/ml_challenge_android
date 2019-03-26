package com.example.ml_challenge.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ml_challenge.R
import com.example.ml_challenge.data.Account
import com.example.ml_challenge.model.JsonAccountsModel

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AccountsFragment.OnAccountListInteractionListener] interface.
 */
class AccountsFragment : Fragment() {

    private var mAccountListener: OnAccountListInteractionListener? = null

    private var mModel: JsonAccountsModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_accounts_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)

                mModel?.let {
                    adapter = AccountsRecyclerViewAdapter(it.getAllAccounts(), mAccountListener)
                }
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAccountListInteractionListener) {
            mAccountListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }

        if(mModel == null) {
            mModel = JsonAccountsModel()
        }
        mModel?.let { it.populateModel(context) }
    }

    override fun onDetach() {
        super.onDetach()
        mAccountListener = null
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
        fun onAccountListInteraction(item: Account?)
    }
}

package com.example.ml_challenge.model

import android.content.Context
import android.os.AsyncTask
import java.lang.ref.WeakReference

class ReadTransactionsTask(val context: WeakReference<Context>,
                           private val jsonTransactionsModel: JsonTransactionsModel?,
                           private val listener: IDataModelListener) : AsyncTask<Int, Void, Boolean>() {
    override fun doInBackground(vararg params: Int?): Boolean {
        if(params?.size > 0) {
            jsonTransactionsModel?.populateModel(context.get(), params[0])
            return true
        }
        return false
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
        listener?.populateModelComplete(result!!)
    }
}
package com.example.bohdan_vdatatesttask

import android.os.AsyncTask

class AsyncThread(val handler: () -> Unit): AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg p0: Void?): String? {
        handler()
        return null
    }
}
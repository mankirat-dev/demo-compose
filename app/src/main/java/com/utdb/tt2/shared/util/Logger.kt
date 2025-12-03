package com.utdb.tt2.shared.util

import android.util.Log

object Logger {
    fun log(msg: String?, tr: Throwable?=null) {
        Log.e("aaaa", msg, tr)
    }
}
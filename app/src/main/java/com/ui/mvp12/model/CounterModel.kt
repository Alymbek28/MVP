package com.ui.mvp12.model

import android.util.Log

class CounterModel {
    
    var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    @JvmName("getCount1")
    fun getCount(): Int {
        return count
    }
}
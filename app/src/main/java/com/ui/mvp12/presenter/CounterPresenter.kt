package com.ui.mvp12.presenter

import android.view.View
import com.ui.mvp12.model.CounterModel
import com.ui.mvp12.view.MainActivity
import com.ui.mvp12.view.MainActivityView

class CounterPresenter {

    private lateinit var view: MainActivityView

    private val counterModel = CounterModel()

    fun increment() {
        counterModel.increment()
        view.updateCounterView(counterModel.count)
        when {
            counterModel.getCount() == 10 -> {
                view.showToast()
            }
            counterModel.getCount() == 15 -> {
                view.textColor()
            }
        }
    }

    fun decrement() {
        counterModel.decrement()
        view.updateCounterView(counterModel.count)
        when {
            counterModel.getCount() == 10 -> {
                view.showToast()
            }
            counterModel.getCount() == 15 -> {
                view.textColor()
            }
        }
    }
    fun attachView(view: MainActivityView) {
        this.view = view
    }
}
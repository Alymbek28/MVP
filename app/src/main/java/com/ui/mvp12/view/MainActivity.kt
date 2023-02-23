package com.ui.mvp12.view

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.ui.mvp12.R
import com.ui.mvp12.databinding.ActivityMainBinding
import com.ui.mvp12.model.CounterModel
import com.ui.mvp12.presenter.CounterPresenter

class MainActivity : AppCompatActivity(), MainActivityView {

    private val counter = CounterModel()

    private lateinit var binding: ActivityMainBinding
    private val presenter = CounterPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        onClick()
    }

    override fun updateCounterView(model: Int) {
        binding.tvCounter.text = model.toString()
    }

    private fun onClick() {
        binding.btnIncrement.setOnClickListener {
            presenter.increment()
        }

        binding.btnDecrement.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun showToast() {
        this.showToast("Поздравляю!")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun textColor() {
        binding.tvCounter.setTextColor(getColor(R.color.red))
    }
}
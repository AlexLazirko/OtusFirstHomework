package com.example.otuscourutines.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewModel> : DaggerAppCompatActivity() {

    abstract var layoutId: Int

    lateinit var vModel: T

    abstract fun getViewModel(): T
    abstract fun setUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        this.vModel = if (this::vModel.isInitialized) {
            vModel
        } else {
            getViewModel()
        }
        setUp()
    }
}
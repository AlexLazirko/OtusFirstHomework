package com.example.otuscourutines.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import dagger.android.DaggerFragment

abstract class BaseFragment<T : ViewModel> : DaggerFragment() {

    abstract var layoutId: Int

    private lateinit var viewModel: T

    abstract fun getViewModel(): T

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(layoutId, container, false)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
package com.example.otuscourutines.base.adapter

import android.view.ViewGroup

interface AdapterDelegate {

    fun createViewHolder(parent: ViewGroup): BaseVH
}
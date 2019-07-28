package com.example.otuscourutines.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    abstract fun bind(item: T)
    open fun unbind() {}
}

/* BaseVH itself was self-sufficient, with all boilerplate hidden.
 * Although, forcing to use PostType as base model was a bit too much.
 */
typealias BaseVH = BaseViewHolder<PostType>
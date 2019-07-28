package com.example.otuscourutines.base.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView


open class PostAdapter : RecyclerView.Adapter<BaseVH>() {

    protected val items: MutableList<PostType> = mutableListOf()
    protected val delegates: SparseArrayCompat<AdapterDelegate> = SparseArrayCompat()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH =
        delegates.get(viewType)!!.createViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseVH, position: Int) = holder.bind(items[position])

    override fun onViewRecycled(holder: BaseVH) = holder.unbind()

    override fun getItemViewType(position: Int): Int = items[position].getPostType()

    fun removeAt(index: Int) {
        items.removeAt(index)
        notifyItemRemoved(index)
    }

    fun remove(item: PostType?, index: Int) {
        item?.let { i ->
            if (items[index] == i) {
                items.remove(i)
                notifyItemRemoved(index)
            }
        }
    }

    fun add(input: List<PostType>) {
        val currentSize = items.size
        items.addAll(input)
        notifyItemRangeInserted(currentSize, items.size)
    }

    fun replace(input: List<PostType>) {
        val oldSize = items.size
        items.clear()
        notifyItemRangeRemoved(0, oldSize)
        items.addAll(input)
        notifyItemRangeInserted(0, items.size)
    }

    fun change(input: PostType) {
        if (items.contains(input)) {
            val index = items.indexOf(input)
            items.removeAt(index)
            items.add(index, input)
            notifyItemChanged(index)
        }
    }

    fun replaceAt(input: PostType, index: Int) {
        items[index] = input
        notifyItemChanged(index)
    }

    fun replace(newPost: PostType, oldPost: PostType) {
        if (items.contains(oldPost)) items.indexOf(oldPost).let {
            items[it] = newPost
            notifyItemChanged(it)
        }
    }

    fun remove(post: PostType) {
        if (items.contains(post)) items.indexOf(post).let {
            items.remove(post)
            notifyItemRemoved(it)
        }
    }
}

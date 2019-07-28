package com.example.otuscourutines.view.main.delegates

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.otuscourutines.R
import com.example.otuscourutines.base.adapter.AdapterDelegate
import com.example.otuscourutines.base.adapter.BaseVH
import com.example.otuscourutines.base.adapter.PostType
import kotlinx.android.synthetic.main.film_item.view.*

class FilmAdapterDelegate(private val clickListener: (filmId: String) -> Unit) : AdapterDelegate {
    override fun createViewHolder(parent: ViewGroup): BaseVH {
        return FilmVH(parent)
    }

    inner class FilmVH(parent: ViewGroup) : BaseVH(parent, R.layout.film_item) {
        override fun bind(item: PostType) {
            item as FilmPost
            Glide.with(itemView.context).load(item.posterPath).into(itemView.ivPoster)
            itemView.tvTitle.text = item.title
            itemView.tvOverview.text = item.overview
            itemView.tvReleaseDaa.text = item.releaseDate
            itemView.filmContainer.setOnClickListener { clickListener(item.id) }
        }
    }
}

data class FilmPost(
    val id: String,
    val title: String,
    val posterPath: String,
    val overview: String,
    val releaseDate: String
) : PostType {
    override fun getPostType() = PostType.DATA
}
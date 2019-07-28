package com.example.otuscourutines.view.main.adapter

import com.example.otuscourutines.base.adapter.PostAdapter
import com.example.otuscourutines.base.adapter.PostType
import com.example.otuscourutines.view.main.delegates.FilmAdapterDelegate

class FilmsAdapter(private val clickListener: (id: String) -> Unit) : PostAdapter() {
    init {
        delegates.append(PostType.DATA, FilmAdapterDelegate(clickListener))
    }
}
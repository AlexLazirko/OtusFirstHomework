package com.example.otuscourutines.view.mapper

import com.example.domains.entity.Film
import com.example.otuscourutines.base.adapter.PostType
import com.example.otuscourutines.view.main.delegates.FilmPost

class Mapper {
    fun mapFilmsToPostModel(items: List<Film>): List<PostType> {
        return items.map {
            FilmPost(
                id = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath
            )
        }
    }
}
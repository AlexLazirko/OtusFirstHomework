package com.example.data.mapper

import com.example.data.api.RetrofitFactory
import com.example.data.model.FilmDetailResponse
import com.example.data.model.FilmResponse
import com.example.data.model.GenreResponse
import com.example.domains.entity.Film
import com.example.domains.entity.FilmDetail
import com.example.domains.entity.Genre

class Mapper {

    fun mapPopularFilmsList(items: List<FilmResponse>): List<Film> {
        return items.map {
            Film(
                id = it.id.orEmpty(),
                title = it.title.orEmpty(),
                posterPath = "${RetrofitFactory.BASE_IMAGE_URL}${it.posterPath}",
                overview = it.overview.orEmpty(),
                releaseDate = it.releaseDate.orEmpty()
            )
        }
    }

    fun mapFilmDetail(film: FilmDetailResponse): FilmDetail {
        return FilmDetail(
            budget = film.budget ?: 0,
            homepage = film.homepage.orEmpty(),
            genres = mapGenreList(film.genres.orEmpty()).orEmpty(),
            overView = film.overView.orEmpty(),
            posterPath = "${RetrofitFactory.BASE_IMAGE_URL}${film.posterPath}",
            title = film.title.orEmpty()
        )
    }

    private fun mapGenreList(genres: List<GenreResponse>): List<Genre> {
        return genres.map { Genre(it.name.orEmpty()) }
    }
}
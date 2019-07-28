package com.example.data.repo

import com.example.data.api.RetrofitFactory
import com.example.data.mapper.Mapper
import com.example.domains.entity.Film
import com.example.domains.entity.FilmDetail
import com.example.domains.repo.Repository


class RepositoryImpl(
    private val mapper: Mapper
) : Repository {

    private val cacheItems: MutableList<Film> = mutableListOf()

    override suspend fun getFilmDetail(name: String): FilmDetail {
        return mapper.mapFilmDetail(RetrofitFactory.getApi().getFilmDetail(name).await())
    }

    override suspend fun getPopularFilms(): List<Film> {
        if (cacheItems.isEmpty()) {
            val response = RetrofitFactory.getApi().getPopularFilms()
            cacheItems.addAll(mapper.mapPopularFilmsList(response.await().items))
        }
        return cacheItems
    }
}
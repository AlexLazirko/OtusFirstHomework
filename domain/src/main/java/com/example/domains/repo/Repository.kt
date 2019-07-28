package com.example.domains.repo

import com.example.domains.entity.Film
import com.example.domains.entity.FilmDetail

interface Repository {
    suspend fun getPopularFilms(): List<Film>
    suspend fun getFilmDetail(name: String): FilmDetail
}
package com.example.domains.usecase

import com.example.domains.entity.FilmDetail

interface FilmDetailUseCase {
    suspend fun getFilmDetail(id: String): FilmDetail
}
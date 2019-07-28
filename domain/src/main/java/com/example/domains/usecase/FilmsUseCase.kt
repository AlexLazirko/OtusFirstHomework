package com.example.domains.usecase

import com.example.domains.entity.Film

interface FilmsUseCase {
    suspend fun getFilms(): List<Film>
}
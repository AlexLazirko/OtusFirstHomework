package com.example.domains.usecase

import com.example.domains.entity.Film
import com.example.domains.repo.Repository

class FilmsUseCaseImpl(
    private val repository: Repository
) : FilmsUseCase {
    override suspend fun getFilms(): List<Film> {
        return repository.getPopularFilms()
    }
}
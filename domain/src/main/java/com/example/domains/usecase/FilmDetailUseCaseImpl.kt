package com.example.domains.usecase

import com.example.domains.entity.FilmDetail
import com.example.domains.repo.Repository

class FilmDetailUseCaseImpl(
    private val repository: Repository
) : FilmDetailUseCase {
    override suspend fun getFilmDetail(id: String): FilmDetail {
        return repository.getFilmDetail(id)
    }
}
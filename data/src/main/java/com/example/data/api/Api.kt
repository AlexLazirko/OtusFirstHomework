package com.example.data.api

import com.example.data.model.FilmDetailResponse
import com.example.data.model.FilmResponse
import com.example.data.model.Response
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("movie/popular")
    fun getPopularFilms(): Deferred<Response<FilmResponse>>

    @GET("movie/{id}")
    fun getFilmDetail(@Path("id") id: String): Deferred<FilmDetailResponse>
}
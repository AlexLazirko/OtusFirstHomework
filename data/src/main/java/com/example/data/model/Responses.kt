package com.example.data.model

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("results")
    val items: List<T>
)

data class FilmResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?
)

data class FilmDetailResponse(
    @SerializedName("budget")
    val budget: Long?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("genres")
    val genres: List<GenreResponse>?,
    @SerializedName("overview")
    val overView: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("title")
    val title: String?
)

data class GenreResponse(
    @SerializedName("name")
    val name: String?
)
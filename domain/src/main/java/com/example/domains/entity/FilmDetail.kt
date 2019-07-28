package com.example.domains.entity

data class FilmDetail(
    val budget: Long,
    val homepage: String,
    val genres: List<Genre>,
    val overView: String,
    val posterPath: String,
    val title: String
) {
}
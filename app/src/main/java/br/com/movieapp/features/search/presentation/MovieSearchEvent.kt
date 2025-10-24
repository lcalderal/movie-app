package br.com.movieapp.features.search.presentation

sealed class MovieSearchEvent() {
    data class EnteredQuery(val value: String) : MovieSearchEvent()
}
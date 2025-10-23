package br.com.movieapp.features.search.domain.source

import br.com.movieapp.core.data.remote.response.SearchResponse
import br.com.movieapp.core.page.MovieSearchPagingSource

interface MovieSearchRemoteDataSource {
    fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource
    suspend fun getSearchMovies(query: String, page: Int): SearchResponse
}
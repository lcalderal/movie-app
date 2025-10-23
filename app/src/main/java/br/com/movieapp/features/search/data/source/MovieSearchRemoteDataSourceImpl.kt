package br.com.movieapp.features.search.data.source

import br.com.movieapp.core.data.remote.response.SearchResponse
import br.com.movieapp.core.data.remote.service.MovieService
import br.com.movieapp.core.page.MovieSearchPagingSource
import br.com.movieapp.features.search.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {
    override fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(
            query = query,
            remoteDataSource = this
        )
    }

    override suspend fun getSearchMovies(
        query: String,
        page: Int
    ): SearchResponse {
        return service.searchMovie(page = page, query = query)
    }
}
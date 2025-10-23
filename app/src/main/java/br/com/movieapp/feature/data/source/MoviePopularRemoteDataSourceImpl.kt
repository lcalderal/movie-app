package br.com.movieapp.feature.data.source

import br.com.movieapp.core.data.remote.response.MovieResponse
import br.com.movieapp.core.data.remote.service.MovieService
import br.com.movieapp.core.page.MoviePagingSource
import br.com.movieapp.feature.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource {
    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page)
    }
}
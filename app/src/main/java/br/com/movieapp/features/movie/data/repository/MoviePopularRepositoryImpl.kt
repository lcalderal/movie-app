package br.com.movieapp.features.movie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.features.domain.repository.MoviePopularRepository
import br.com.movieapp.features.domain.source.MoviePopularRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MoviePopularRepositoryImpl(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : MoviePopularRepository {
    override fun getPopularMovies(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getPopularMoviesPagingSource()
            }
        ).flow
    }
}
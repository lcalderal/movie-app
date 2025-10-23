package br.com.movieapp.features.movie.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.features.domain.repository.MoviePopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MoviePopularRepository) {

    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularMovies(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }
}
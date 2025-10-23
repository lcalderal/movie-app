package br.com.movieapp.features.search.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.core.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow

interface MovieSearchRepository {
    fun getSearchMovies(query: String, paging: PagingConfig) : Flow<PagingData<MovieSearch>>
}
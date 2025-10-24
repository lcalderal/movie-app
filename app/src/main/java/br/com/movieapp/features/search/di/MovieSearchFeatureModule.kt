package br.com.movieapp.features.search.di

import br.com.movieapp.core.data.remote.service.MovieService
import br.com.movieapp.features.search.data.repository.MovieSearchRepositoryImpl
import br.com.movieapp.features.search.data.source.MovieSearchRemoteDataSourceImpl
import br.com.movieapp.features.search.domain.repository.MovieSearchRepository
import br.com.movieapp.features.search.domain.source.MovieSearchRemoteDataSource
import br.com.movieapp.features.search.domain.usecase.GetMovieSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieSearchFeatureModule {

    @Provides
    @Singleton
    fun provideMovieSearchRemoteDataSource(service: MovieService): MovieSearchRemoteDataSource {
        return MovieSearchRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideMovieSearchRepository(dataSource: MovieSearchRemoteDataSource): MovieSearchRepository {
        return MovieSearchRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideGetMovieSearchUseCase(repository: MovieSearchRepository) : GetMovieSearchUseCase {
        return GetMovieSearchUseCase(repository)
    }
}
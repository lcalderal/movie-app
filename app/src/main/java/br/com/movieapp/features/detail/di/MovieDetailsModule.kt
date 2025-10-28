package br.com.movieapp.features.detail.di

import br.com.movieapp.core.data.remote.service.MovieService
import br.com.movieapp.features.detail.data.repository.MovieDetailsRepositoryImpl
import br.com.movieapp.features.detail.data.source.MovieDetailsRemoteDataSourceImpl
import br.com.movieapp.features.detail.domain.repository.MovieDetailsRepository
import br.com.movieapp.features.detail.domain.source.MovieDetailsRemoteDataSource
import br.com.movieapp.features.detail.domain.usecase.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsModule {

    @Provides
    @Singleton
    fun provideMovieDetailsRemoteDataSource(service: MovieService) : MovieDetailsRemoteDataSource {
        return MovieDetailsRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        remoteDataSource: MovieDetailsRemoteDataSource
    ) : MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(
            remoteDataSource = remoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideGetMovieDetailsUseCase(
        repository: MovieDetailsRepository
    ) : GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(
            repository = repository
        )
    }
}
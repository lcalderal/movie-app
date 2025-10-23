package br.com.movieapp.feature.di

import br.com.movieapp.core.data.remote.service.MovieService
import br.com.movieapp.feature.data.repository.MoviePopularRepositoryImpl
import br.com.movieapp.feature.data.source.MoviePopularRemoteDataSourceImpl
import br.com.movieapp.feature.domain.repository.MoviePopularRepository
import br.com.movieapp.feature.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.feature.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun providesMovieRepository(dataSource: MoviePopularRemoteDataSource): MoviePopularRepository {
        return MoviePopularRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun providesGetMoviesPopularUseCase(
        repository: MoviePopularRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(repository)
    }
}
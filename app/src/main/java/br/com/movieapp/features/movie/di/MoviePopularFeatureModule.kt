package br.com.movieapp.features.movie.di

import br.com.movieapp.core.data.remote.service.MovieService
import br.com.movieapp.features.movie.data.repository.MoviePopularRepositoryImpl
import br.com.movieapp.features.movie.data.source.MoviePopularRemoteDataSourceImpl
import br.com.movieapp.features.movie.domain.repository.MoviePopularRepository
import br.com.movieapp.features.movie.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.features.movie.domain.usecase.GetPopularMoviesUseCase
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
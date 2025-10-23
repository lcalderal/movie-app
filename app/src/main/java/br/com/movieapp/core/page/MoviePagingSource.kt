package br.com.movieapp.core.page

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.features.movie.data.mapper.toMovie
import br.com.movieapp.features.movie.domain.source.MoviePopularRemoteDataSource
import coil.network.HttpException
import okio.IOException

private const val LIMIT = 20

class MoviePagingSource(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getPopularMovies(pageNumber)
            val movies = response.movieResultList

            LoadResult.Page(
                data = movies.toMovie(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )
        } catch (e: IOException) {
            e.printStackTrace()
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }
}
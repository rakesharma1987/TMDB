package com.form.tbdbclient.data.repository.movie.dataSourceImpl

import com.form.tbdbclient.data.api.TMDBService
import com.form.tbdbclient.data.model.movie.MovieList
import com.form.tbdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey : String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}
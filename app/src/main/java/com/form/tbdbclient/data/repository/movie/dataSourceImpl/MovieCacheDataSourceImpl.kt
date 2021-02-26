package com.form.tbdbclient.data.repository.movie.dataSourceImpl

import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.data.repository.movie.dataSource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList =  ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
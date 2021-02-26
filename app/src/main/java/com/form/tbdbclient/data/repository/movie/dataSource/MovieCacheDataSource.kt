package com.form.tbdbclient.data.repository.movie.dataSource

import com.form.tbdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}
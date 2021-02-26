package com.form.tbdbclient.data.repository.movie.dataSource

import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}
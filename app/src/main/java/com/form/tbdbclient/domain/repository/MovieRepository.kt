package com.form.tbdbclient.domain.repository

import com.form.tbdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}
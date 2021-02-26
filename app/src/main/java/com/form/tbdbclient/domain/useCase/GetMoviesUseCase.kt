package com.form.tbdbclient.domain.useCase

import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}
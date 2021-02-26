package com.form.tbdbclient.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.domain.useCase.GetMoviesUseCase
import com.form.tbdbclient.domain.useCase.UpdateMoviesUseCase

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase, private val updateMoviesUseCase: UpdateMoviesUseCase) : ViewModel() {
    fun getMovies() : LiveData<List<Movie>?> = liveData {
        val moviesList : List<Movie>? = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() : LiveData<List<Movie>?> = liveData {
        val movieList : List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}
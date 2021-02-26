package com.form.tbdbclient.presentation.di.movie

import android.graphics.Movie
import com.form.tbdbclient.domain.useCase.GetMoviesUseCase
import com.form.tbdbclient.domain.useCase.UpdateMoviesUseCase
import com.form.tbdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase, updateMoviesUseCase: UpdateMoviesUseCase) : MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}
package com.form.tbdbclient.presentation.di.core

import com.form.tbdbclient.domain.repository.ArtistRepository
import com.form.tbdbclient.domain.repository.MovieRepository
import com.form.tbdbclient.domain.repository.TvShowRepository
import com.form.tbdbclient.domain.useCase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun providUpdateTvShwoUseCase(tvShowRepository: TvShowRepository) : UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides

    fun provideGetArtistUseCase(artistRepository: ArtistRepository) : GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository) : UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }
}
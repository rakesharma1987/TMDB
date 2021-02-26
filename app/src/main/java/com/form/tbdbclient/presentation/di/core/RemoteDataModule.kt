package com.form.tbdbclient.presentation.di.core

import com.form.tbdbclient.data.api.TMDBService
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.form.tbdbclient.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.form.tbdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.form.tbdbclient.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideRemoteMovieDataSource(tmdbService : TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideRemoteTvShowDataSource(tmdbService : TMDBService) : TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideRemoteArtistDataSource(tmdbService : TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}
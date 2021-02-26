package com.form.tbdbclient.presentation.di.core

import com.form.tbdbclient.data.db.ArtistDao
import com.form.tbdbclient.data.db.MovieDao
import com.form.tbdbclient.data.db.TvShowDao
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.form.tbdbclient.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.form.tbdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.form.tbdbclient.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }


}
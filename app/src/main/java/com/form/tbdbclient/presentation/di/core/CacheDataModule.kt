package com.form.tbdbclient.presentation.di.core

import com.form.tbdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.form.tbdbclient.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.form.tbdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.form.tbdbclient.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource{
        return MovieCacheDataSourceImpl()

    }
    @Singleton
    @Provides
    fun provideTvShowDataSource() : TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistDataSource() : ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

}
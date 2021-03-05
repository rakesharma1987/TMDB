package com.form.tbdbclient.presentation.di.core

import com.form.tbdbclient.data.repository.ArtistRepositoryImpl
import com.form.tbdbclient.data.repository.MoviRepositoryImpl
import com.form.tbdbclient.data.repository.TvShowsRepositoryImpl
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.form.tbdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.form.tbdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.form.tbdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.form.tbdbclient.domain.repository.ArtistRepository
import com.form.tbdbclient.domain.repository.MovieRepository
import com.form.tbdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDataSource : MovieRemoteDataSource,
                                movieLocalDataSource: MovieLocalDataSource,
                               movieCacheDataSource: MovieCacheDataSource
                               ) : MovieRepository{
        return MoviRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(tvShowRemoteDataSource: TvShowRemoteDataSource,
                                tvShowLocalDataSource: TvShowLocalDataSource,
                                tvShowCacheDataSource: TvShowCacheDataSource
                                ) : TvShowRepository{
        return TvShowsRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepositiry(artistRemoteDataSource: ArtistRemoteDataSource,
                                artistLocalDataSource: ArtistLocalDataSource,
                                artistCacheDataSource: ArtistCacheDataSource
                                ) : ArtistRepository{
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}
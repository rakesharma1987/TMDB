package com.form.tbdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.form.tbdbclient.data.db.ArtistDao
import com.form.tbdbclient.data.db.MovieDao
import com.form.tbdbclient.data.db.TMDBDatabse
import com.form.tbdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context) : TMDBDatabse{
        return Room.databaseBuilder(context, TMDBDatabse::class.java, "tmdbClient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabse: TMDBDatabse) : MovieDao{
        return tmdbDatabse.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabse: TMDBDatabse) : TvShowDao{
        return tmdbDatabse.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabse: TMDBDatabse) : ArtistDao{
        return tmdbDatabse.artistDao()
    }
}
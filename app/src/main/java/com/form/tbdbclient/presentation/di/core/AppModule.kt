package com.form.tbdbclient.presentation.di.core

import android.content.Context
import com.form.tbdbclient.presentation.di.artist.ArtistSubComponent
import com.form.tbdbclient.presentation.di.movie.MovieSubComponenet
import com.form.tbdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponenet::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContect() : Context{
        return context.applicationContext
    }
}
package com.form.tbdbclient.presentation.di.core

import com.form.tbdbclient.presentation.di.artist.ArtistSubComponent
import com.form.tbdbclient.presentation.di.core.*
import com.form.tbdbclient.presentation.di.movie.MovieSubComponenet
import com.form.tbdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class, RepositoryModule::class, DatabaseModule::class, UseCaseModule::class,
    RemoteDataModule::class, LocalDataModule::class, CacheDataModule::class])
interface AppComponenet {
    fun movieSubComponent() : MovieSubComponenet.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}
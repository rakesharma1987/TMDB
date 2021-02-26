package com.form.tbdbclient.presentation

import android.app.Application
import com.form.tbdbclient.BuildConfig
import com.form.tbdbclient.presentation.di.Injector
import com.form.tbdbclient.presentation.di.artist.ArtistSubComponent
import com.form.tbdbclient.presentation.di.core.*
import com.form.tbdbclient.presentation.di.movie.MovieSubComponenet
import com.form.tbdbclient.presentation.di.tvShow.TvShowSubComponent

class App : Application(), Injector{
    private lateinit var appComponenet : AppComponenet
    override fun onCreate() {
        super.onCreate()
        appComponenet = DaggerAppComponenet.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponenet(): MovieSubComponenet {
        return appComponenet.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponenet.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponenet.artistSubComponent().create()
    }
}
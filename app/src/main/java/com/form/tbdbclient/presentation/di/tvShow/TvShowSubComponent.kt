package com.form.tbdbclient.presentation.di.tvShow

import com.form.tbdbclient.presentation.di.movie.MovieModule
import com.form.tbdbclient.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [MovieModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : TvShowSubComponent
    }
}
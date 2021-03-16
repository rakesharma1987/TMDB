package com.form.tbdbclient.presentation.di.tvShow

import com.form.tbdbclient.presentation.di.movie.MovieModule
import com.form.tbdbclient.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : TvShowSubComponent
    }
}
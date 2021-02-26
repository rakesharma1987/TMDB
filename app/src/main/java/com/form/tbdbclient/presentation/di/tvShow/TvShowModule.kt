package com.form.tbdbclient.presentation.di.tvShow

import com.form.tbdbclient.domain.useCase.GetTvShowUseCase
import com.form.tbdbclient.domain.useCase.UpdateTvShowUseCase
import com.form.tbdbclient.presentation.tvShow.TvShowVieModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @Provides
    fun provideTvShowViewMOdelFactory(getTvShowUseCase: GetTvShowUseCase, updateTvShowUseCase: UpdateTvShowUseCase) : TvShowVieModelFactory{
        return TvShowVieModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}
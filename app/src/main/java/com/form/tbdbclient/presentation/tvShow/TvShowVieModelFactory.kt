package com.form.tbdbclient.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.form.tbdbclient.domain.useCase.GetTvShowUseCase
import com.form.tbdbclient.domain.useCase.UpdateTvShowUseCase

class TvShowVieModelFactory(private val getTvShowUseCase: GetTvShowUseCase, private val updateTvShowUseCase: UpdateTvShowUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}
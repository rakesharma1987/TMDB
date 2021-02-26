package com.form.tbdbclient.presentation.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.domain.useCase.GetTvShowUseCase
import com.form.tbdbclient.domain.useCase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase) : ViewModel(){

    private fun getTvShow() : LiveData<List<TvShow>?> = liveData {
        val tvShowList : List<TvShow>? = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    private fun updateTvShow() : LiveData<List<TvShow>?> = liveData {
        val tvShowList : List<TvShow>? = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}
package com.form.tbdbclient.domain.useCase

import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShow()
}
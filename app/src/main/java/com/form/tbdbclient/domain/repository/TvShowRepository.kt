package com.form.tbdbclient.domain.repository

import com.form.tbdbclient.data.model.TvShow.TvShow

interface TvShowRepository {
    suspend fun getTvShow() : List<TvShow>
    suspend fun UpdateTvShow() : List<TvShow>
}
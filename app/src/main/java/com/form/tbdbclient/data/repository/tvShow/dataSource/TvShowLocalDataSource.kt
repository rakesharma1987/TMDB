package com.form.tbdbclient.data.repository.tvShow.dataSource

import com.form.tbdbclient.data.model.TvShow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB() : List<TvShow>
    suspend fun saveTvShowToDB(movies : List<TvShow>)
    suspend fun clearAll()
}
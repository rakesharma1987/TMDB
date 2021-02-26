package com.form.tbdbclient.data.repository.tvShow.dataSource

import com.form.tbdbclient.data.model.TvShow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache() : List<TvShow>
    suspend fun saveTvShowToCache(movies : List<TvShow>)
}
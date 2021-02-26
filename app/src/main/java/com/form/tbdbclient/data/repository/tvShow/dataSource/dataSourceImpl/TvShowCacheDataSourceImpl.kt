package com.form.tbdbclient.data.repository.tvShow.dataSource.dataSourceImpl

import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
package com.form.tbdbclient.data.repository.tvShow.dataSource.dataSourceImpl

import com.form.tbdbclient.data.api.TMDBService
import com.form.tbdbclient.data.model.TvShow.TvShowList
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey : String) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShow(apiKey)
    }
}
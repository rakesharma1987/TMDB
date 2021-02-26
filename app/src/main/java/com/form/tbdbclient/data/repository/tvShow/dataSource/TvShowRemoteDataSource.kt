package com.form.tbdbclient.data.repository.tvShow.dataSource

import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.model.TvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows() : Response<TvShowList>
}
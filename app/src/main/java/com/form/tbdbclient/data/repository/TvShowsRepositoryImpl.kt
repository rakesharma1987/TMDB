package com.form.tbdbclient.data.repository

import android.util.Log
import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.form.tbdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.form.tbdbclient.domain.repository.TvShowRepository

class TvShowsRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource,
                            private val tvShowLocalDataSource: TvShowLocalDataSource,
                            private val tvShowCacheDataSource: TvShowCacheDataSource
                            ) : TvShowRepository {
    override suspend fun getTvShow(): List<TvShow> {
        return getTvShowFromCache()
    }

    override suspend fun UpdateTvShow(): List<TvShow> {
        val newListOfTvShow : List<TvShow> = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowsFromApi() : List<TvShow>{
        lateinit var tvShowsList : List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null){
                tvShowsList = body.tvShows
            }
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        return tvShowsList
    }

    suspend fun getTvShowFromLocalDb() : List<TvShow>{
        lateinit var tvShowsList : List<TvShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        if (tvShowsList.size > 0){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowFromCache() : List<TvShow>{
        lateinit var tvShowsList : List<TvShow>
        try {
            tvShowsList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        if (tvShowsList.size > 0){
            return tvShowsList
        }else{
            tvShowsList = getTvShowFromLocalDb()
            tvShowCacheDataSource.saveTvShowToCache(tvShowsList)
        }
        return tvShowsList
    }

}
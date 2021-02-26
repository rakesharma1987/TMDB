package com.form.tbdbclient.data.db

import androidx.room.*
import com.form.tbdbclient.data.model.TvShow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow : List<TvShow>)

    @Query("DELETE FROM popular_tv_show")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM POPULAR_TV_SHOW")
    suspend fun getTvShows() : List<TvShow>

}
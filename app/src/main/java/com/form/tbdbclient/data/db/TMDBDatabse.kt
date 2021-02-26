package com.form.tbdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.data.model.movie.Movie

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabse : RoomDatabase(){
    abstract fun movieDao() : MovieDao
    abstract fun tvShowDao() : TvShowDao
    abstract fun artistDao() : ArtistDao
}
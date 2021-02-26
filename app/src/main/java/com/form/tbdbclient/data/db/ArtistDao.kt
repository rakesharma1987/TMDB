package com.form.tbdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.form.tbdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artist : List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists() : List<Artist>
}
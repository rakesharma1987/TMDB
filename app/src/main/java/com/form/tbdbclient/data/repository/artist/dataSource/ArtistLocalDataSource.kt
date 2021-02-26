package com.form.tbdbclient.data.repository.artist.dataSource

import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(movies : List<Artist>)
    suspend fun clearAll()
}
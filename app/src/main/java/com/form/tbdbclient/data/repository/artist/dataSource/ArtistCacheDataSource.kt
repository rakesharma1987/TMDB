package com.form.tbdbclient.data.repository.artist.dataSource
import com.form.tbdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtisToCache(movies : List<Artist>)
}
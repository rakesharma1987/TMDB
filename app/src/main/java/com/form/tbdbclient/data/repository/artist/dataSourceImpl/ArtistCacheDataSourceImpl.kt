package com.form.tbdbclient.data.repository.artist.dataSourceImpl

import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtisToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}
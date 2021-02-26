package com.form.tbdbclient.data.repository.artist.dataSource

import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist() : Response<ArtistList>
}
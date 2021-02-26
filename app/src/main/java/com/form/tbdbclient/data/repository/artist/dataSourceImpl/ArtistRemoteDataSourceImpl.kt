package com.form.tbdbclient.data.repository.artist.dataSourceImpl

import com.form.tbdbclient.data.api.TMDBService
import com.form.tbdbclient.data.model.artist.ArtistList
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey : String) : ArtistRemoteDataSource{
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }
}
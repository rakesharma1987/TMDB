package com.form.tbdbclient.data.repository

import android.util.Log
import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.form.tbdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.form.tbdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(private val artistRemoteDataSource: ArtistRemoteDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource
                           ) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        var newListOfAdrtist : List<Artist> = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfAdrtist)
        artistCacheDataSource.saveArtisToCache(newListOfAdrtist)
        return newListOfAdrtist
    }

    suspend fun getArtistFromApi() : List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null){
                artistList = body.artists
            }
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromLocalDb() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (ex : Exception){
            Log.i("MyTag:", ex.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistFromLocalDb()
            artistCacheDataSource.saveArtisToCache(artistList)
        }
        return artistList
    }
}
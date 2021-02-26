package com.form.tbdbclient.domain.repository

import com.form.tbdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}
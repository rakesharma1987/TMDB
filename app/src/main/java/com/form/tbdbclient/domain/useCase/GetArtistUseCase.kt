package com.form.tbdbclient.domain.useCase

import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = artistRepository.getArtists()
}
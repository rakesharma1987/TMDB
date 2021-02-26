package com.form.tbdbclient.domain.useCase

import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = artistRepository.updateArtists()
}
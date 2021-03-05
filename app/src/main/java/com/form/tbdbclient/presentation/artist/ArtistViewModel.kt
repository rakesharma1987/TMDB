package com.form.tbdbclient.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.domain.useCase.GetArtistUseCase
import com.form.tbdbclient.domain.useCase.UpdateArtistUseCase

class ArtistViewModel(private val getArtistUseCase: GetArtistUseCase, private val updateArtistUseCase: UpdateArtistUseCase) : ViewModel(){
        fun getArtist() : LiveData<List<Artist>?> = liveData {
            val artistList : List<Artist>? = getArtistUseCase.execute()
            emit(artistList)
        }

    fun updateArtist() : LiveData<List<Artist>?> = liveData {
        val artistList : List<Artist>? = updateArtistUseCase.execute()
        emit(artistList)
    }
}
package com.form.tbdbclient.presentation.di.artist

import com.form.tbdbclient.domain.useCase.GetArtistUseCase
import com.form.tbdbclient.domain.useCase.UpdateArtistUseCase
import com.form.tbdbclient.presentation.artist.ArtistVieModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistUseCase: GetArtistUseCase, updateArtistUseCase: UpdateArtistUseCase) : ArtistVieModelFactory{
        return ArtistVieModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}
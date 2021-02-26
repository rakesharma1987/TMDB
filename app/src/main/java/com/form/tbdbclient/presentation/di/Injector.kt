package com.form.tbdbclient.presentation.di

import com.form.tbdbclient.presentation.di.artist.ArtistSubComponent
import com.form.tbdbclient.presentation.di.movie.MovieSubComponenet
import com.form.tbdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponenet() : MovieSubComponenet
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent
}
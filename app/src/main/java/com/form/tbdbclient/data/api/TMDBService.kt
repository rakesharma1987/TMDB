package com.form.tbdbclient.data.api

import com.form.tbdbclient.data.model.artist.ArtistList
import com.form.tbdbclient.data.model.movie.MovieList
import com.form.tbdbclient.data.model.TvShow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey : String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey : String) : Response<ArtistList>


}
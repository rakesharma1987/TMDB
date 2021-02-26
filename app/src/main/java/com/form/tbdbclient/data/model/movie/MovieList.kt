package com.form.tbdbclient.data.model.movie


import com.form.tbdbclient.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>,
)
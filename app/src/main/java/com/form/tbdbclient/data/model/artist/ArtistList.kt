package com.form.tbdbclient.data.model.artist


import com.form.tbdbclient.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,
)
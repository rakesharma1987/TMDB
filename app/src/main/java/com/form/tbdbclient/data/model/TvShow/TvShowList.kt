package com.form.tbdbclient.data.model.TvShow


import com.form.tbdbclient.data.model.TvShow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)
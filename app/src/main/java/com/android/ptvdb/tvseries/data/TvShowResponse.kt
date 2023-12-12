package com.android.ptvdb.tvseries.data

import com.google.gson.JsonArray
import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @field:SerializedName("page")
    var page: Int = 0,

    @field:SerializedName("results")
    var results: JsonArray?
)
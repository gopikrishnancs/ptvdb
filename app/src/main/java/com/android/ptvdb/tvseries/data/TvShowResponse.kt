package com.android.ptvdb.tvseries.data

import com.google.gson.annotations.SerializedName


data class TvShowResponse(
    @field:SerializedName("page")
    var page: Int? = null,

    @field:SerializedName("results")
    var results: ArrayList<Results> = arrayListOf(),

    @SerializedName("total_pages")
    var totalPages   : Int? = null,

    @SerializedName("total_results" )
    var totalResults : Int? = null
)
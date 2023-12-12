package com.android.ptvdb.tvseries.data

import com.google.gson.annotations.SerializedName

data class PosterResponse(
    @SerializedName("backdrops" ) var backdrops : ArrayList<Backdrops> = arrayListOf(),
    @SerializedName("id"        ) var id        : Int?                 = null,
    @SerializedName("logos"     ) var logos     : ArrayList<String>    = arrayListOf(),
    @SerializedName("posters"   ) var posters   : ArrayList<Posters>   = arrayListOf()
)
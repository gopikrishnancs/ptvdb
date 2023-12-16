package com.android.ptvdb.tvseries.data

import com.google.gson.annotations.SerializedName


data class Genres (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null

)
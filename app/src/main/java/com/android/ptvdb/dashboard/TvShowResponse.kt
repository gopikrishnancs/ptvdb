package com.android.ptvdb.dashboard

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @field:SerializedName("success")
    val success: Boolean = false
)
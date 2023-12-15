package com.android.ptvdb.data.network

import com.android.ptvdb.tvseries.data.TvShowResponse
import com.android.ptvdb.dashboard.data.AuthResponse
import com.android.ptvdb.tvseries.data.PosterResponse
import retrofit2.http.GET
import retrofit2.http.Headers


private const val END_URL_AUTH = "authentication"
private const val END_URL_TV_LIST = "discover/tv?include_adult=false&language=en-US&page=1&sort_by=popularity.desc"
private const val END_URL_POSTER_TV_SHOW = "tv/94722/images"


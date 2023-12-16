package com.android.ptvdb.data.network

import com.android.ptvdb.dashboard.data.AuthResponse
import com.android.ptvdb.tvseries.data.ParticularTvShowResponse
import com.android.ptvdb.tvseries.data.TvShowResponse
import retrofit2.http.GET
import retrofit2.http.Headers


private const val END_URL_AUTH = "authentication"
private const val END_URL_TV_SHOW_LIST = "discover/tv?include_adult=false&language=en-US&page=1&sort_by=popularity.desc"
private const val END_URL_TV_SHOW = "tv/1419?language=en-US"
private const val END_URL_POSTER_TV_SHOW = "tv/94722/images"
private const val AUTH_KEY = "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4" +
        "NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ." +
        "dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA"
private  const val TYPE = "Accept: application/json"

interface APIService {

    @Headers(TYPE, AUTH_KEY)
    @GET(END_URL_AUTH)
    suspend fun getAuth(): AuthResponse

    @Headers(TYPE, AUTH_KEY)
    @GET(END_URL_TV_SHOW_LIST)
    suspend fun getTvShows(): TvShowResponse

    @Headers(TYPE, AUTH_KEY)
    @GET(END_URL_TV_SHOW)
    suspend fun getParticularTvShow(): ParticularTvShowResponse

}

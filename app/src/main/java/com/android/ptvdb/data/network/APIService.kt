package com.android.ptvdb.data.network

import com.android.ptvdb.dashboard.TvShowResponse
import com.android.ptvdb.dashboard.AuthResponse
import retrofit2.http.GET
import retrofit2.http.Headers


private const val END_URL_AUTH = "3/authentication"
private const val END_URL_MOVIE_LIST = "tv/changes?page=1"

interface APIService {

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET(END_URL_AUTH)
    suspend fun getAuth(): AuthResponse

    @GET(END_URL_MOVIE_LIST)
    suspend fun fetchMovie(): TvShowResponse
}
package com.android.ptvdb.data.network

import com.android.ptvdb.tvseries.data.TvShowResponse
import com.android.ptvdb.dashboard.data.AuthResponse
import retrofit2.http.GET
import retrofit2.http.Headers


private const val END_URL_AUTH = "authentication"
private const val END_URL_TV_LIST = "discover/tv?include_adult=false&language=en-US&page=1&sort_by=popularity.desc"

interface APIService {

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET(END_URL_AUTH)
    suspend fun getAuth(): AuthResponse

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET(END_URL_TV_LIST)
    suspend fun getTvShows(): TvShowResponse
}
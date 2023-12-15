package com.android.ptvdb.newdata.datasource.network

import com.android.ptvdb.dashboard.data.AuthResponse
import com.android.ptvdb.tvseries.data.PosterResponse
import com.android.ptvdb.tvseries.data.TvShowResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET(END_URL_AUTH)
    suspend fun getAuth(): AuthResponse

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET(END_URL_TV_LIST)
    suspend fun getTvShows(): TvShowResponse

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET(END_URL_TV_LIST)
    suspend fun getTvShowsNew(): String

    @Headers("Accept: application/json", "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA")
    @GET()
    suspend fun getPostersTvSHow(): PosterResponse

    companion object {
        private const val END_URL_AUTH = "https://api.themoviedb.org/"
        private const val END_URL_TV_LIST = "api_key="
    }
}


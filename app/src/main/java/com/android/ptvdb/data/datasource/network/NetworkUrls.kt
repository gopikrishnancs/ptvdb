package com.android.ptvdb.data.datasource.network

import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkUrls @Inject constructor() {
    fun getAuthenticationUrl(): URL {
        return URL("${BASE_URL}authentication")
    }

    fun getTvShows(page: Int =1): URL {
        return URL("${BASE_URL}discover/tv?&page=$page&sort_by=popularity.desc?")
    }

    fun getShowDetails(showId : Int): URL {
        return URL("${BASE_URL}tv/$showId?language=en-US")
    }


    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjllM2IyYjNiYjk2Y2EyZGU2NTg2MmQ4NmRkYjIyZSIsInN1YiI6IjY1NzQ2N2FiYTg0YTQ3MDExYjVmZTcwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dnW2JN2mDe2GMRoB-QksmG8Lh_DayFe0Bu7jLcIIbCA"
    }
}
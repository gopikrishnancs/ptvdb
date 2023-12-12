package com.android.ptvdb.data.network

import com.android.ptvdb.dashboard.data.AuthResponse
import com.android.ptvdb.tvseries.data.TvShowResponse

object Repository {

    val apiService = RetrofitCI.apiService

    suspend fun getAuth(): AuthResponse {
        return apiService.getAuth()
    }

    suspend fun getTvShow(): TvShowResponse {
        return apiService.getTvShows()
    }

}
package com.android.ptvdb.data.network

import com.android.ptvdb.dashboard.data.AuthResponse
import com.android.ptvdb.tvseries.data.ParticularTvShowResponse
import com.android.ptvdb.tvseries.data.TvShowResponse

object Repository {

    private val apiService = RetrofitCI.apiService

    suspend fun getAuth(): AuthResponse {
        return apiService.getAuth()
    }

    suspend fun getTvShow(): TvShowResponse {
        return apiService.getTvShows()
    }

    suspend fun getParticularTvShow(): ParticularTvShowResponse{
        return apiService.getParticularTvShow()
    }

}
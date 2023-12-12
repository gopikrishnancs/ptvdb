package com.android.ptvdb.data.network

import com.android.ptvdb.dashboard.AuthResponse
object Repository {

    val apiService = RetrofitCI.apiService

    suspend fun getAuth(): AuthResponse {
        return apiService.getAuth()
    }

}
package com.android.ptvdb.data.network

import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton


    @Singleton
    class requestUrls @Inject constructor() {

        fun getAuthUrl(): URL {
            return URL("${BASE_URL}3/authentication?$API_KEY")
        }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/"
        private const val API_KEY = "api_key="
    }
}
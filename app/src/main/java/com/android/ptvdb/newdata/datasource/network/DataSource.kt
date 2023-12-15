package com.android.ptvdb.newdata.datasource.network

import com.android.ptvdb.newdata.datasource.network.APIService
import com.android.ptvdb.newdata.model.TvShows
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor(
    private val requestUrls: RequestUrls,
    private val jsonData: RemoteData,
    private val apiService: APIService
){

    suspend fun getTvShowData() : List<TvShows> = withContext(Dispatchers.IO){
        val response: String = apiService.getTvShowsNew()
        jsonData.getTvShowJson(response)
    }
}
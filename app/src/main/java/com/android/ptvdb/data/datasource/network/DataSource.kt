package com.android.ptvdb.data.datasource.network

import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.TvShowsDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor(
    private val jsonData: RemoteData,
    private val networkUrls: NetworkUrls,
    private val networkClient: NetworkClient,
){

    suspend fun getTvShowData() : List<TvShows> = withContext(Dispatchers.IO){
        val requestUrl = networkUrls.getTvShows()
        val response: String = networkClient.getResponseFromHttpUrl(requestUrl)
        jsonData.getTvShowJson(response)
    }

    suspend fun getParticularTvShow(showId : Int): List<TvShowsDetails> = withContext(Dispatchers.IO){
        val requestUrl = networkUrls.getShowDetails(showId)
        val response: String = networkClient.getResponseFromHttpUrl(requestUrl)
        jsonData.getParticularTvShowJson(response)
    }

    suspend fun getTvShowDataResponse() : String =  withContext(Dispatchers.IO) {
        val requestUrl = networkUrls.getTvShows()
        val response: String = networkClient.getResponseFromHttpUrl(requestUrl)
        response
    }

    suspend fun getParticularShowResponse(showId : Int): String = withContext(Dispatchers.IO){
        val requestUrl = networkUrls.getShowDetails(showId)
        val response: String = networkClient.getResponseFromHttpUrl(requestUrl)
        response
    }
}
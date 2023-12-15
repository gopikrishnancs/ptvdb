package com.android.ptvdb.newdata.datasource.network

import com.android.ptvdb.newdata.model.TvShows
import com.android.ptvdb.tvseries.data.TvShowResponse
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteData @Inject constructor(private val urls: RequestUrls) {

    @Throws(Exception::class)
    fun getTvShowResponse(response: TvShowResponse) {
        response.results
    }

    @Throws(Exception::class)
    fun getTvShowJson(response: String): List<TvShows> {

        if (response.isEmpty()) {
            return emptyList()
        }

        val tvShowList: MutableList<TvShows> = ArrayList()
        val responseJson = JSONObject(response)
        val tvJsonArray = responseJson.getJSONArray("results")

        for (i: Int in 0 until tvJsonArray.length()) {
            tvShowList.add(
                TvShows(
                    showId = tvJsonArray.getJSONObject(i).getInt("id"),
                    showName = tvJsonArray.getJSONObject(i).getString("name"),
                    showPosterUrl = tvJsonArray.getJSONObject(i).getString("poster_path"),
                    showOverview = tvJsonArray.getJSONObject(i).getString("overview"),
                    showLanguage = tvJsonArray.getJSONObject(i).getString("original_language")
                )
            )
        }
        return tvShowList
    }
}
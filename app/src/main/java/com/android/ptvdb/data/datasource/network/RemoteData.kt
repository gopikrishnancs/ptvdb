package com.android.ptvdb.data.datasource.network

import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.TvShowsDetails
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteData @Inject constructor() {
    @Throws(Exception::class)
    fun getTvShowJson(response: String): List<TvShows> {

        if (response.isEmpty()) {
            return emptyList()
        }

        val tvShowList: MutableList<TvShows> = ArrayList()
        val responseJson = JSONObject(response)
        val tvJsonArray = responseJson.getJSONArray("results")

        for (i: Int in 0 until tvJsonArray.length()) {
            try{
                tvShowList.add(
                    TvShows(
                        showId = tvJsonArray.getJSONObject(i).getInt("id"),
                        showName = tvJsonArray.getJSONObject(i).getString("name"),
                        showPosterUrl = tvJsonArray.getJSONObject(i).getString("poster_path"),
                        showOverview = tvJsonArray.getJSONObject(i).getString("overview"),
                        showLanguage = tvJsonArray.getJSONObject(i).getString("original_language"),
                        showReleaseDate = tvJsonArray.getJSONObject(i).getString("first_air_date"),
                        showAverageVote = tvJsonArray.getJSONObject(i).getString("vote_average")
                    )
                )
            }catch (e:Exception){
                e.cause
            }

        }
        return tvShowList
    }

    @Throws(Exception::class)
    fun getParticularTvShowJson(response: String): List<TvShowsDetails> {
        if (response.isEmpty()) {
            return emptyList()
        }

        val tvShowDetailList: MutableList<TvShowsDetails> = ArrayList()
        val responseJson = JSONObject(response)
        //val test1 = responseJson.getJSONObject("poster_path")
        //val test2 = responseJson.getString("backdrop_path")
        //val test3 = responseJson.get("backdrop_path")
        //val tvJsonArray = responseJson.getJSONArray("results")

        try {
            tvShowDetailList.add(
                TvShowsDetails(
                    showId = responseJson.getInt("id"),
                    showName = responseJson.getString("name"),
                    showPosterUrl = responseJson.getString("poster_path"),
                    showOverview = responseJson.getString("overview"),
                    showLanguage = responseJson.getString("original_language"),
                    showReleaseDate = responseJson.getString("first_air_date"),
                    showAverageVote = responseJson.getString("vote_average")
                )
            )
        }catch (e:Exception){
            e.cause
        }

        return tvShowDetailList
    }
}
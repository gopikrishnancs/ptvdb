package com.android.ptvdb.data.datasource.repository.tvshows

import androidx.lifecycle.LiveData
import com.android.ptvdb.data.datasource.database.DatabaseDataSource
import com.android.ptvdb.data.datasource.network.DataSource
import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.TvShowsDetails
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository @Inject constructor(
    private val dataSource: DataSource,
    private val databaseDataSource: DatabaseDataSource
) {
    suspend fun getTvShowFromNetwork(): List<TvShows> {
        return dataSource.getTvShowData()
    }

    suspend fun getTvShowFromDatabase(): String {
        return dataSource.getTvShowDataResponse()
    }

    suspend fun getParticularTvShow(showId: Int): List<TvShowsDetails>{
        return dataSource.getParticularTvShow(showId)
    }

    suspend fun getParticularTvShowFromDatabase(showId: Int): String{
        return dataSource.getParticularShowResponse(showId)
    }

}


package com.android.ptvdb.data.datasource.repository.tvshows

import androidx.lifecycle.LiveData
import com.android.ptvdb.data.datasource.database.DatabaseDataSource
import com.android.ptvdb.data.datasource.network.DataSource
import com.android.ptvdb.data.model.TvShows
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

    fun getTvShowFromDatabase(): LiveData<List<TvShows>> {
        return databaseDataSource.getAllTvShows()
    }
}

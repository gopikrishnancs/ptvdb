package com.android.ptvdb.data.datasource.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.showsAsDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabaseDataSource @Inject constructor(
    private val database: AppDatabase
) {

    fun getAllTvShows(): LiveData<List<TvShows>> {
        val allTvShows = database.tvShowDao.getAllTvSHows()
        // Change to distinct until changed
        return allTvShows.map { tvEntityList ->
            tvEntityList.showsAsDatabaseModel()
        }
    }

    suspend fun addTvShow(
        tvShow: TvShows
    ) = withContext(Dispatchers.IO) {
        with(tvShow.showsAsDatabaseModel()) {
            database.tvShowDao.addShowsToDb(tvShowEntity = this)
        }
    }
}
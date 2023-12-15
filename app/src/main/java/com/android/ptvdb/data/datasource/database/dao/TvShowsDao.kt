package com.android.ptvdb.data.datasource.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.ptvdb.data.datasource.database.entity.TvShowEntity

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShowsToDb(tvShowEntity: TvShowEntity)

    @Query("SELECT * FROM tv_shows_table")
    fun getAllTvSHows(): LiveData<List<TvShowEntity>>

    @Query("DELETE FROM tv_shows_table")
    fun deleteAllTvShows()

}
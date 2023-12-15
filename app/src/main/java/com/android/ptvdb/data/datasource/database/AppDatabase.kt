package com.android.ptvdb.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.ptvdb.data.datasource.database.dao.TvShowDao
import com.android.ptvdb.data.datasource.database.entity.TvShowEntity


@Database(
    entities = [TvShowEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val tvShowDao: TvShowDao
}
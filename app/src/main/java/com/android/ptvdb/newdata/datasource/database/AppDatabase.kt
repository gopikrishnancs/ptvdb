package com.android.ptvdb.newdata.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.ptvdb.newdata.datasource.database.dao.TvShowDao
import com.android.ptvdb.newdata.datasource.database.entity.TvShowEntity


@Database(
    entities = [TvShowEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val tvShowDao: TvShowDao
}
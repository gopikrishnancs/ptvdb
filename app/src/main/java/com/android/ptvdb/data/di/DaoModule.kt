package com.developersbreach.composeactors.di

import com.android.ptvdb.data.datasource.database.AppDatabase
import com.android.ptvdb.data.datasource.database.dao.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesTvShowsDao(
        database: AppDatabase
    ): TvShowDao {
        return database.tvShowDao
    }
}
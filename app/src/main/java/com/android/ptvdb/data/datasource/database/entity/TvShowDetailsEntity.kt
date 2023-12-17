package com.android.ptvdb.data.datasource.database.entity

import androidx.compose.runtime.Stable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_shows_table")
data class TvShowDetailsEntity (
    @Stable
    @PrimaryKey
    @ColumnInfo(name = "column_show_id")
    val showId: Int,

    @ColumnInfo(name = "column_show_name")
    val showName: String,

    @ColumnInfo(name = "column_show_posterUrl")
    val showPosterUrl: String,

    @ColumnInfo(name = "column_show_Overview")
    val showOverview: String,

    @ColumnInfo(name = "column_show_Language")
    val showLanguage: String,

    @ColumnInfo(name = "column_show_ReleaseDate")
    val showReleaseDate: String,

    @ColumnInfo(name = "column_show_AverageVote")
    val showAverageVote: String,
)
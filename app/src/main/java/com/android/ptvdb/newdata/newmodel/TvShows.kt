package com.android.ptvdb.newdata.newmodel

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.android.ptvdb.newdata.datasource.database.entity.TvShowEntity

@Immutable
data class TvShows(
    @Stable val showId: Int,
    val showName: String,
    val showPosterUrl: String,
    val showOverview: String,
    val showLanguage: String
)

fun TvShows.showsAsDatabaseModel(): TvShowEntity {
    return TvShowEntity(
        showId = this.showId,
        showName = this.showName,
        showPosterUrl = this.showPosterUrl,
        showOverview = this.showOverview,
        showLanguage = this.showLanguage
    )
}

fun List<TvShowEntity>.showsAsDatabaseModel(): List<TvShows> {
    return map {
        TvShows(
            showId = it.showId,
            showName = it.showName,
            showPosterUrl = it.showPosterUrl,
            showOverview = it.showOverview,
            showLanguage = it.showLanguage
        )
    }
}
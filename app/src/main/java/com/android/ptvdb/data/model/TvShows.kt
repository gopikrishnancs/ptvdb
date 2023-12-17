package com.android.ptvdb.data.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.android.ptvdb.data.datasource.database.entity.TvShowEntity

@Immutable
data class TvShows(
    @Stable val showId: Int,
    val showName: String,
    val showPosterUrl: String,
    val showOverview: String,
    val showLanguage: String,
    val showReleaseDate: String,
    val showAverageVote: String
)

fun TvShows.showsAsDatabaseModel(): TvShowEntity {
    return TvShowEntity(
        showId = this.showId,
        showName = this.showName,
        showPosterUrl = this.showPosterUrl,
        showOverview = this.showOverview,
        showLanguage = this.showLanguage,
        showReleaseDate = this.showReleaseDate,
        showAverageVote = this.showAverageVote
    )
}

fun List<TvShowEntity>.showsAsDatabaseModel(): List<TvShows> {
    return map {
        TvShows(
            showId = it.showId,
            showName = it.showName,
            showPosterUrl = it.showPosterUrl,
            showOverview = it.showOverview,
            showLanguage = it.showLanguage,
            showAverageVote = it.showAverageVote,
            showReleaseDate = it.showReleaseDate
        )
    }
}
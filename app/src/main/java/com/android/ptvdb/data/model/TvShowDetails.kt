package com.android.ptvdb.data.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.android.ptvdb.data.datasource.database.entity.TvShowEntity
import com.android.ptvdb.data.datasource.database.entity.TvShowDetailsEntity

@Immutable
data class TvShowsDetails(
    @Stable val showId: Int,
    val showName: String,
    val showPosterUrl: String,
    val showOverview: String,
    val showLanguage: String
)

fun TvShowsDetails.showsAsDatabaseModel(): TvShowEntity {
    return TvShowEntity(
        showId = this.showId,
        showName = this.showName,
        showPosterUrl = this.showPosterUrl,
        showOverview = this.showOverview,
        showLanguage = this.showLanguage
    )
}

fun List<TvShowDetailsEntity>.showsAsDatabaseModel(): List<TvShowsDetails> {
    return map {
        TvShowsDetails(
            showId = it.showId,
            showName = it.showName,
            showPosterUrl = it.showPosterUrl,
            showOverview = it.showOverview,
            showLanguage = it.showLanguage
        )
    }
}
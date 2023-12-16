package com.android.ptvdb.screens.ui

import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.TvShowsDetails

data class HomeItemUiState(
    var showList: List<TvShows> = emptyList()
)
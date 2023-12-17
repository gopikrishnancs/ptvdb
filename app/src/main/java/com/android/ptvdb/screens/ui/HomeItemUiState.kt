package com.android.ptvdb.screens.ui

import com.android.ptvdb.data.model.TvShows

data class HomeItemUiState(
    var showList: List<TvShows> = emptyList(),
    var showResponse: String = ""
)
package com.android.ptvdb.screens.ui

import com.android.ptvdb.data.model.TvShowsDetails

data class DetailItemUiState(
    var detailList: List<TvShowsDetails> = emptyList(),
    var showResponse: String = ""
)
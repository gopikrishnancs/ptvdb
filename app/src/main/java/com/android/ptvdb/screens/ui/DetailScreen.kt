package com.android.ptvdb.screens.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ptvdb.screens.ui.viewmodel.DetailScreenViewModel

@Composable
fun DetailScreen(viewModel: DetailScreenViewModel = hiltViewModel(), showId: Int) {

    DetailScreenUI(
        detailItemUiState = viewModel.detailScreenUiState,
        showId = showId
    )
}
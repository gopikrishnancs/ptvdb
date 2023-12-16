package com.android.ptvdb.screens.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ptvdb.screens.ui.viewmodel.DetailScreenViewModel
import com.android.ptvdb.screens.ui.viewmodel.HomeScreenViewModel

@Composable
fun DetailScreen(viewModel: DetailScreenViewModel = hiltViewModel(), showId: Int) {

    DetailScreenUI(
        modifier = Modifier,
        detailItemUiState = viewModel.detailScreenUiState,
        showId = showId
    )
}
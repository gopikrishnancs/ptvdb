package com.android.ptvdb.screens.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ptvdb.screens.ViewModel

@Composable
fun HomeScreen(viewModel: ViewModel = hiltViewModel(),
               navigateToDetailScreen: (Int) -> Unit) {

    HomeScreenUI(modifier = Modifier,
        homeItemUiState = viewModel.homeScreenItemUiState,
        navigateToDetailScreen = navigateToDetailScreen)
}
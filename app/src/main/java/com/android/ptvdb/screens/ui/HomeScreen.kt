package com.android.ptvdb.screens.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.ptvdb.screens.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel? = hiltViewModel(),
               navigateToDetailScreen: (Int) -> Unit) {

    HomeScreenUI(modifier = Modifier,
        homeItemUiState = viewModel!!.homeScreenItemUiState,
        navigateToDetailScreen = navigateToDetailScreen)
}
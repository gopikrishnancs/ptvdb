package com.android.ptvdb.screens.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreenUI(modifier: Modifier = Modifier,
                 homeItemUiState: HomeItemUiState,
                 navigateToDetailScreen: (Int) -> Unit) {
    val scaffoldState = rememberScrollState()
    val modalSheetState = rememberModalBottomSheetState()

    Surface(color = Color.Blue, modifier = modifier) {
        Scaffold(topBar = { TopAppBar(title = {"est"}) })
        {
            it.calculateBottomPadding()
            Box() {
                HomeScreenUI(homeItemUiState = homeItemUiState,
                    navigateToDetailScreen = navigateToDetailScreen)
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
private fun HomeScreenUI(homeItemUiState: HomeItemUiState,
                         navigateToDetailScreen: (Int) -> Unit){
    val tvShowListState = rememberLazyListState()
    val homePagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        1
    }
    Column(Modifier.fillMaxSize()) {
        VerticalPager(state = homePagerState) {
        when (it){
                0->{
                    TvShowListContent(
                        homeItemUiState = homeItemUiState,
                        tvShowLazyList = tvShowListState,
                        navigateToDetailScreen = navigateToDetailScreen
                    )
                }
        }
        }
    }
}
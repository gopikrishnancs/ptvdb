package com.android.ptvdb.screens.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.ptvdb.data.datasource.repository.tvshows.TvShowRepository
import com.android.ptvdb.screens.ui.HomeItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: TvShowRepository,
): ViewModel() {

    var homeScreenItemUiState by mutableStateOf(HomeItemUiState())
        private set

    init {
        viewModelScope.launch {
            getTvShows()
        }
    }

    private suspend fun getTvShows(){
        homeScreenItemUiState = HomeItemUiState(showList = repository.getTvShowFromNetwork(), showResponse = repository.getTvShowFromDatabase())
    }
}
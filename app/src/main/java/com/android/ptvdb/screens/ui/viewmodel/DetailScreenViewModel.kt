package com.android.ptvdb.screens.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.ptvdb.data.datasource.repository.tvshows.TvShowRepository
import com.android.ptvdb.screens.ui.DetailItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: TvShowRepository,
): ViewModel() {

    val showId : Int = savedStateHandle["showId"]!!

    var detailScreenUiState by mutableStateOf(DetailItemUiState())
        private set

    init {
        viewModelScope.launch {
            getTvShowDetails()
        }
    }

    private suspend fun getTvShowDetails(){
        detailScreenUiState = DetailItemUiState(detailList = repository.getParticularTvShow(showId), showResponse = repository.getParticularTvShowFromDatabase(showId))
    }
}


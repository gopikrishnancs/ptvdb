package com.android.ptvdb.tvseries.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.ptvdb.data.network.Repository
import com.android.ptvdb.tvseries.data.ParticularTvShowResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(private val tvRepository: Repository):ViewModel()
{
    var tvResponse: ParticularTvShowResponse by mutableStateOf(ParticularTvShowResponse())
    var isLoading: Boolean by mutableStateOf(false)
    var isResponseSuccess: Boolean by mutableStateOf(false)

    fun getParticularTvSHow(showId: Int){
        viewModelScope.launch {
            isLoading = true
            viewModelScope.launch {
                try {
                    tvResponse = tvRepository.getParticularTvShow()
                    isResponseSuccess = true
                    isLoading = false
                }
                catch (exception:Exception){
                    isResponseSuccess = false
                    isLoading = false
                }
            }
        }
    }

}

class TvShowDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowDetailViewModel::class.java)) {
            return TvShowDetailViewModel(Repository) as T
        }
        throw IllegalArgumentException("tv_show_detail_exception")
    }
}


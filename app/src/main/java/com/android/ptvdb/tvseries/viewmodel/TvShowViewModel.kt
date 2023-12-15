package com.android.ptvdb.tvseries.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.ptvdb.newdata.datasource.network.Repository
import com.android.ptvdb.tvseries.data.PosterResponse
import com.android.ptvdb.tvseries.data.TvShowResponse
import kotlinx.coroutines.launch

class TvShowViewModel(val tvRepository: Repository): ViewModel() {


    var tvResponse: TvShowResponse by mutableStateOf(TvShowResponse())
    var posterResponse: PosterResponse by mutableStateOf(PosterResponse())
    var isLoading: Boolean by mutableStateOf(false)
    var isResponseSuccess: Boolean by mutableStateOf(false)


    fun getPopularTvShows(){
        isLoading = true
        viewModelScope.launch {

            try {
                tvResponse = tvRepository.getTvShow()
                isResponseSuccess = true
                isLoading = false
            }
            catch (exception:Exception){
                isResponseSuccess = false
                isLoading = false
            }

        }
    }

    fun getPostersTvShows(){
        isLoading = true
        viewModelScope.launch {
            try {
                posterResponse = tvRepository.getPosterImages()
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
class TvShowViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowViewModel::class.java)) {
            return TvShowViewModel(Repository) as T
        }
        throw IllegalArgumentException("tv_show_exception")
    }
}
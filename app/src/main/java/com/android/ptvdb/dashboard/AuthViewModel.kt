package com.android.ptvdb.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.ptvdb.data.network.Repository
import kotlinx.coroutines.launch

class AuthViewModel(val authRepository: Repository): ViewModel() {


    var authResponse: AuthResponse by mutableStateOf(AuthResponse())
    var isLoading: Boolean by mutableStateOf(false)


    fun getAuthentication(){
        isLoading = true
        viewModelScope.launch {

            try {
                authRepository.getAuth()
                isLoading = false
            }
            catch (exception:Exception){
                authResponse.statusMessage = "Fail"
                isLoading = false
            }

        }
    }

}
class AuthenticationViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(Repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
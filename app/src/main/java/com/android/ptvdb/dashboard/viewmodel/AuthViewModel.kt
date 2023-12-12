package com.android.ptvdb.dashboard.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.android.ptvdb.dashboard.data.AuthResponse
import com.android.ptvdb.data.network.Repository
import kotlinx.coroutines.launch

class AuthViewModel(val authRepository: Repository): ViewModel() {


    var authResponse: AuthResponse by mutableStateOf(AuthResponse())
    var isLoading: Boolean by mutableStateOf(false)
    var isAuthSuccess: Boolean by mutableStateOf(false)


    fun getAuthentication(){
        isLoading = true
        viewModelScope.launch {

            try {
                authRepository.getAuth()
                isAuthSuccess = true
                isLoading = false
            }
            catch (exception:Exception){
                authResponse.statusMessage = "Fail"
                isAuthSuccess = false
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
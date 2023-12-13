package com.android.ptvdb.dashboard.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.ptvdb.dashboard.viewmodel.AuthViewModel
import com.android.ptvdb.dashboard.viewmodel.AuthenticationViewModelFactory
import com.android.ptvdb.tvseries.ui.TvShowRoute

//basic screen class with Basic Retrofit Response to navigate to next screen if the response is success
@SuppressLint("SuspiciousIndentation")
@Composable
fun DashBoardScreen() {

    val authenticationViewModel: AuthViewModel = viewModel(factory = AuthenticationViewModelFactory())

        GetAuth(authenticationViewModel)

}

@Composable
fun GetAuth(authenticationViewModel: AuthViewModel) {

    LaunchedEffect(Unit, block = {
        authenticationViewModel.getAuthentication()
    })

    if (authenticationViewModel.isLoading) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = Color.Cyan,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .align(Alignment.Center)
                )
            }

        }

    } else if (authenticationViewModel.isAuthSuccess){
        TvShowRoute()
    }
}

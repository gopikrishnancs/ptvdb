package com.android.ptvdb.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DashBoardScreen(message: String) {

    val authenticationViewModel: AuthViewModel = viewModel(factory = AuthenticationViewModelFactory())

    if (message.contains("guest", ignoreCase = true)) {
        GetAuth(authResponse = authenticationViewModel.authResponse, authenticationViewModel)

    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome\n$message",
                style = TextStyle(
                    fontSize = 22.sp, color = Color.Green,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W700
                )
            )
        }
    }
}

@Composable
fun GetAuth(authResponse: AuthResponse, authenticationViewModel: AuthViewModel) {

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

    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Authentication \n${authResponse.statusMessage}",
                style = TextStyle(
                    fontSize = 22.sp, color = Color.Green,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W700
                )
            )
        }
    }
}

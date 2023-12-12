package com.android.ptvdb

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.ptvdb.dashboard.ui.DashBoardScreen

object Destinations {
    const val WELCOME = "welcome to ptvdb"
}
@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Destinations.WELCOME) {
        composable(Destinations.WELCOME) {
            DashBoardScreen()
        }
    }
}

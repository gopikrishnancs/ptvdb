package com.android.ptvdb

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.ptvdb.Destinations.POPULAR_TV_SERIES
import com.android.ptvdb.dashboard.DashBoardRoute

object Destinations {
    const val POPULAR_TV_SERIES = "Tv Series"
    const val WELCOME_ROUTE = "welcome"
}
@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Destinations.WELCOME_ROUTE) {
        composable(Destinations.WELCOME_ROUTE) {
            DashBoardRoute("guest")
        }
        composable(POPULAR_TV_SERIES){
            val key  = it.arguments?.getString("auth_key")
            if (key != null) {
                DashBoardRoute(message = key)
            }
        }
    }
}

package com.android.ptvdb

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.ptvdb.screens.ui.HomeScreen
import com.android.ptvdb.screens.ui.actions.NavActions

object Destinations {
    const val DASHBOARD = "Dashboard"
}
@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    
    val actions = remember(navController) {
        NavActions(navController)
    }
    
    NavHost(navController = navController, startDestination = Destinations.DASHBOARD) {
        composable(Destinations.DASHBOARD) {
            HomeScreen(navigateToDetailScreen = actions.navigateToDetailScreen)
        }
    }
}

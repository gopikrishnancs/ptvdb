package com.android.ptvdb

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.ptvdb.screens.ui.DetailScreen
import com.android.ptvdb.screens.ui.HomeScreen
import com.android.ptvdb.screens.ui.actions.NavActions

object Destinations {
    const val DASHBOARD = "Dashboard"
    const val DETAIL = "show-detail"
    const val SHOW_ID = "showId"
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
        composable(
            route = "${Destinations.DETAIL}/{${Destinations.SHOW_ID}}",
            arguments = listOf(
                navArgument(Destinations.SHOW_ID)
                {type = NavType.IntType}
            )
        ){
            var showId = it.arguments?.getInt(Destinations.SHOW_ID)
            if(showId==null){
                showId = 0
            }
            DetailScreen(showId = showId)
        }
    }
}

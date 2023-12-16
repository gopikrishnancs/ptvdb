package com.android.ptvdb

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.ptvdb.dashboard.ui.DashBoardScreen
import com.android.ptvdb.tvseries.ui.TvShowDetailScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController(),
             routes: Destinations = Destinations) {

    val actions = remember(navController) {
        NavActions(navController, routes)
    }

    NavHost(navController = navController, startDestination = Destinations.DASHBOARD) {
        composable(Destinations.DASHBOARD) {
            DashBoardScreen(navigateToSelectedShow = actions.navigateToSelectedShow)
        }
        
        composable(
            route = "${Destinations.DETAIL}/{${routes.SHOW_ID}}",
            arguments = listOf(
                navArgument(routes.SHOW_ID)
                {type = NavType.IntType}
            )
        ){
            var showId = it.arguments?.getInt(Destinations.SHOW_ID)
            if(showId==null){
                showId = 0
            }
            TvShowDetailScreen(showId)
        }

    }
}

package com.android.ptvdb

import androidx.navigation.NavHostController

class NavActions(
    private val navController: NavHostController,
    private val routes: Destinations
) {
    val navigateToSelectedShow: (Int) -> Unit = { showId ->
        navController.navigate("${routes.DETAIL}/$showId")
    }

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
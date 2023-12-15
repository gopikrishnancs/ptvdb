package com.android.ptvdb.screens.ui.actions

import androidx.navigation.NavController

class NavActions(private val navController: NavController){
    val navigateToDetailScreen: (Int) -> Unit = {showId: Int ->
        navController.navigate("show-detail/$showId")
    }

    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
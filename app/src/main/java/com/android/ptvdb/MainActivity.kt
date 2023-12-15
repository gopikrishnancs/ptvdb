package com.android.ptvdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.ptvdb.screens.ui.HomeScreen
import com.android.ptvdb.ui.theme.PtvdbTheme
import dagger.hilt.android.AndroidEntryPoint

//MainActivity to set theme and content and navigation for the application class
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PtvdbTheme {
                // A surface container using the 'background' color from the theme
                NavGraph()
            }
        }
    }

}
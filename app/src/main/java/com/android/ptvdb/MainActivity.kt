package com.android.ptvdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.ptvdb.ui.theme.PtvdbTheme

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
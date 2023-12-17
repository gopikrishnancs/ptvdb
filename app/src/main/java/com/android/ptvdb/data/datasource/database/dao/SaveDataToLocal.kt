package com.android.ptvdb.data.datasource.database.dao

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SaveDataToLocal (context: Context, stringKey: String, stringValue: String) {
    val preferencesManager = remember { LocalDataStore(context) }
    val data = remember { mutableStateOf(preferencesManager.getData(stringKey, "")) }

    // Use the data variable in your Composable

    // Update data and save to SharedPreferences
    preferencesManager.saveData(stringKey, stringValue)
    data.value = stringValue
}
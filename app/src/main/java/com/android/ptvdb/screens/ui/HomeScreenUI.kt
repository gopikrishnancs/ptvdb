package com.android.ptvdb.screens.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.android.ptvdb.data.datasource.database.dao.LocalDataStore
import com.android.ptvdb.data.model.TvShows
import org.json.JSONObject


@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    homeItemUiState: HomeItemUiState,
    navigateToDetailScreen: (Int) -> Unit
) {

    showList(homeItemUiState = homeItemUiState, navigateToDetailScreen)

    if(homeItemUiState.showResponse!=""){
        LocalDataStore(LocalContext.current).saveData("LocalShowList", homeItemUiState.showResponse)
    }


}

@Composable
fun showList(homeItemUiState: HomeItemUiState, navigateToSelectedShow: (Int) -> Unit) {
    val tvShowList: List<TvShows> = homeItemUiState.showList
    val tvShowListStore: String = (LocalDataStore(LocalContext.current).getData("LocalShowList", ""))

    if (tvShowList.isEmpty()) {
        if(tvShowListStore != ""){
            val mTvShowList: MutableList<TvShows> = ArrayList()
            val responseJson = JSONObject(tvShowListStore)
            val tvJsonArray = responseJson.getJSONArray("results")

            for (i: Int in 0 until tvJsonArray.length()) {
                try{
                    mTvShowList.add(
                        TvShows(
                            showId = tvJsonArray.getJSONObject(i).getInt("id"),
                            showName = tvJsonArray.getJSONObject(i).getString("name"),
                            showPosterUrl = tvJsonArray.getJSONObject(i).getString("poster_path"),
                            showOverview = tvJsonArray.getJSONObject(i).getString("overview"),
                            showLanguage = tvJsonArray.getJSONObject(i).getString("original_language"),
                            showReleaseDate = tvJsonArray.getJSONObject(i).getString("first_air_date"),
                            showAverageVote = tvJsonArray.getJSONObject(i).getString("vote_average")
                        )
                    )
                }catch (e:Exception){
                    e.cause
                }

            }
            homeItemUiState.showList = mTvShowList
            showList(homeItemUiState = homeItemUiState, navigateToSelectedShow = navigateToSelectedShow)
        }else{
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Please check your network, if it works, Sorry! it might be us the Requested URL or Tv Show may be down temporarily, please try with some other movie data.",
                    textAlign = TextAlign.Center
                )
            }
        }

    } else {
        Scaffold {
            it.calculateBottomPadding()
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(top = 50.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(1.dp)
                ) {
                    item {
                        for (items in tvShowList) {
                            val paddingModifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clickable(onClick = { navigateToSelectedShow(items.showId) })
                            Card(modifier = paddingModifier) {
                                Row {

                                    AsyncImage(
                                        model = "https://image.tmdb.org/t/p/w500/${items.showPosterUrl}",
                                        contentDescription = "This is an example image"
                                    )

                                    Column() {
                                        Text(
                                            text = items.showName,
                                            fontSize = 24.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black,
                                        )
                                        if (items.showLanguage == "en") {
                                            Text(
                                                text = "Language : English",
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = Color.Black
                                            )
                                        }
                                        Text(
                                            text = "Release Date : " + items.showReleaseDate,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Black
                                        )
                                        Text(
                                            text = "Average Rating : ${items.showAverageVote}",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Black
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
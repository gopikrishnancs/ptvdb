package com.android.ptvdb.screens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import coil.compose.rememberAsyncImagePainter
import com.android.ptvdb.data.datasource.database.dao.LocalDataStore
import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.TvShowsDetails
import org.json.JSONObject

@Composable
fun DetailScreenUI(
    detailItemUiState: DetailItemUiState,
    showId: Int) {
    ShowTvDetails(detailItemUiState = detailItemUiState, showId)

    if(detailItemUiState.showResponse!=""){
        LocalDataStore(LocalContext.current).saveData(showId.toString(), detailItemUiState.showResponse)
    }
}

@Composable
fun ShowTvDetails(detailItemUiState: DetailItemUiState, showId: Int) {
    val tvShowList: List<TvShowsDetails> = detailItemUiState.detailList
    val tvShowDetailStore: String = (LocalDataStore(LocalContext.current).getData(showId.toString(), ""))

    if (tvShowList.isEmpty()) {
        if(tvShowDetailStore != ""){
            val mTvShowDetailList: MutableList<TvShowsDetails> = ArrayList()
            val responseJson = JSONObject(tvShowDetailStore)

            try {
                mTvShowDetailList.add(
                    TvShowsDetails(
                        showId = responseJson.getInt("id"),
                        showName = responseJson.getString("name"),
                        showPosterUrl = responseJson.getString("poster_path"),
                        showOverview = responseJson.getString("overview"),
                        showLanguage = responseJson.getString("original_language"),
                        showReleaseDate = responseJson.getString("first_air_date"),
                        showAverageVote = responseJson.getString("vote_average")
                    )
                )
            }catch (e:Exception){
                e.cause
            }

            detailItemUiState.detailList = mTvShowDetailList
            ShowTvDetails(detailItemUiState = detailItemUiState, showId)
        }else{
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Please check your network, if it works, Sorry! it might be us the Requested URL or Tv Show may be down temporarily, please try with some other movie data.",
                    textAlign = TextAlign.Center
                )
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            for (items in tvShowList) {
                Column {
                    Image(
                        painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500/${items.showPosterUrl}"),
                        contentDescription = items.showOverview,
                        modifier = Modifier.size(500.dp)
                    )



                    Text(
                        text = items.showName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally)
                    )


                    if (items.showLanguage == "en") {
                        Text(
                            text = "Language : English",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            modifier = Modifier
                                .width(200.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                    }


                    Text(
                        text = "Release Date : " + items.showReleaseDate,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally)
                    )


                    Text(
                        text = "Average Rating : ${items.showAverageVote}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .width(200.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = "Overview : ${items.showOverview}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .width(300.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                }
            }
        }
    }
}
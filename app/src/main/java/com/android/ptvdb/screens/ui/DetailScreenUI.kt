package com.android.ptvdb.screens.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.android.ptvdb.data.model.TvShows
import com.android.ptvdb.data.model.TvShowsDetails

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DetailScreenUI(
    modifier: Modifier = Modifier,
    detailItemUiState: DetailItemUiState,
    showId: Int
) {
    val scaffoldState = rememberScrollState()
    val modalSheetState = rememberModalBottomSheetState()

    ShowTvDetails(detailItemUiState = detailItemUiState)
}

@Composable
fun ShowTvDetails(detailItemUiState: DetailItemUiState){
    val tvShowList: List<TvShowsDetails> = detailItemUiState.detailList

    if(tvShowList.isEmpty()){
        Column(){
            Text(text = "Sorry! Request URL or Tv Show not found, please try with some other movie data.")
        }
    }else{
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
                                .clickable(onClick = { })
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
                                            text = "Release Date : " + items.showId,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Black
                                        )
                                        val userRating: String = items.showPosterUrl
                                        Text(
                                            text = "Average Rating : $userRating",
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
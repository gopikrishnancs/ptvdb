package com.android.ptvdb.tvseries.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.android.ptvdb.tvseries.data.TvShowResponse
import com.android.ptvdb.tvseries.model.TvShowModel
import com.android.ptvdb.tvseries.viewmodel.TvShowViewModel
import com.android.ptvdb.tvseries.viewmodel.TvShowViewModelFactory

private  val showList = mutableListOf<TvShowModel>()
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Search here", color = Color.Red, fontSize = 14.sp) },
        Modifier
            .border(2.dp, Color.Blue)
            .padding(10.dp)
            .height(20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun TvShowScreen(navigateToSelectedShow: (Int) -> Unit) {
    val tvShowViewModel: TvShowViewModel = viewModel(factory = TvShowViewModelFactory())
    tvShows(tvResponse = tvShowViewModel.tvResponse, tvShowViewModel, navigateToSelectedShow)
}

@Composable
fun tvShows(tvResponse: TvShowResponse, tvShowViewModel: TvShowViewModel, navigateToSelectedShow: (Int) -> Unit) {

    LaunchedEffect(Unit, block = {
        tvShowViewModel.getPopularTvShows()
    })

    if (tvShowViewModel.isLoading) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = Color.Cyan,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .align(Alignment.Center)
                )
            }

        }

    } else if (tvResponse.results!=null) {
        ListDemo(response = tvResponse, navigateToSelectedShow)
    } else {
        Text(
            text = "Database error unable to fetch movies",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )
    }
}

@Composable
fun ListDemo(response: TvShowResponse, navigateToSelectedShow: (Int) -> Unit) {
    // Add data to the personsList

    for(items in response.results){
        val userRating = items.voteAverage!!.toInt() percentOf items.voteCount!!
        showList.add(TvShowModel(items.id!!, items.name!!, items.posterPath!!, items.adult!!, items.overview!!, items.originalLanguage!!, items.firstAirDate!!, userRating.toString()))
    }

    // ... Add other names to the list

    Scaffold(topBar = { TopBar() }, modifier = Modifier.padding(20.dp),
        content = {it.calculateTopPadding()
            Box(modifier = Modifier
                .background(Color.White)
                .padding(top = 50.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(1.dp)
                    ) {
                        items(showList) { model ->
                            ListItem(model = model, onCLickShow = navigateToSelectedShow)
                        }
                    }
                }
            }
        }
    )
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ListItem(model: TvShowModel, onCLickShow: (Int) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        val paddingModifier = Modifier
            .padding(10.dp)
            .clickable(onClick = { onCLickShow(model.id) })
            Card(modifier = paddingModifier) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500/${model.imagePath}",
                        contentDescription = "This is an example image"
                    )

                    Column {
                        Text(
                            text = model.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        if(model.language == "en"){
                            Text(
                                text = "Language : English",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )
                        }
                        Text(
                            text = "Release Date : " + model.releaseDate,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        val userRating : String = model.userRating.substring(0, 1)
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

infix fun Int.percentOf(value: Int): Int {
    return if (this == 0) 0
    else (value / this.toFloat()).toInt()
}












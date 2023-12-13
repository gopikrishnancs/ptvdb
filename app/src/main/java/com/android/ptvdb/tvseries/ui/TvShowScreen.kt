package com.android.ptvdb.tvseries.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.android.ptvdb.tvseries.model.TvShowModel
import com.android.ptvdb.tvseries.data.TvShowResponse
import com.android.ptvdb.tvseries.viewmodel.TvShowViewModel
import com.android.ptvdb.tvseries.viewmodel.TvShowViewModelFactory

private  val showList = mutableListOf<TvShowModel>()

@Composable
fun TvShowScreen() {

    val tvShowViewModel: TvShowViewModel = viewModel(factory = TvShowViewModelFactory())

    tvShows(tvResponse = tvShowViewModel.tvResponse, tvShowViewModel)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun tvShows(tvResponse: TvShowResponse, tvShowViewModel: TvShowViewModel) {

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
        ListDemo(response = tvResponse)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListDemo(response: TvShowResponse) {
    // Add data to the personsList

    for(items in response.results){
        showList.add(TvShowModel(items.name!!, items.posterPath!!))
    }

    // ... Add other names to the list

    Scaffold(
        content = {
            Box(modifier = Modifier.background(Color.White)) {
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
                            .padding(10.dp)
                    ) {
                        items(showList) { model ->
                            ListItem(model = model)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ListItem(model: TvShowModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        val paddingModifier = Modifier.padding(10.dp)
        Card(modifier = paddingModifier) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500/${model.imagePath}",
                    contentDescription = "This is an example image"
                )
                Text(
                    text = model.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
            }
        }
    }
}

@Composable
fun imageLoader(posterPath: String){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500/$posterPath",
        contentDescription = "This is an example image"
    )
}










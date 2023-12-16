package com.android.ptvdb.tvseries.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.android.ptvdb.tvseries.data.ParticularTvShowResponse
import com.android.ptvdb.tvseries.viewmodel.TvShowDetailViewModel
import com.android.ptvdb.tvseries.viewmodel.TvShowDetailViewModelFactory

@Composable
internal fun TvShowDetailScreen(showId : Int) {

    val viewModel: TvShowDetailViewModel = viewModel(factory = TvShowDetailViewModelFactory())
    tvShows(tvResponse = viewModel.tvResponse, viewModel, showId)

}

@Composable
fun tvShows(tvResponse: ParticularTvShowResponse, viewModel: TvShowDetailViewModel, showId: Int) {
    LaunchedEffect(Unit, block = {
        viewModel.getParticularTvSHow(showId)
    })

    if (viewModel.isLoading) {
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

    } else if (tvResponse!=null && viewModel.isResponseSuccess) {
        showUI(tvResponse = tvResponse)
   }
}

@Composable
fun showUI(tvResponse: ParticularTvShowResponse){
    Scaffold {it.calculateBottomPadding()
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(model = "https://image.tmdb.org/t/p/w500/${tvResponse.posterPath}", contentDescription = tvResponse.overview)
            Text(
                text = tvResponse.name!!,
                Modifier.padding(10.dp).align(Alignment.CenterHorizontally),
                color = Color.Black, fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
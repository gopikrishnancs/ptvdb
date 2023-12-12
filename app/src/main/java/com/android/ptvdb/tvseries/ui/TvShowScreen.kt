package com.android.ptvdb.tvseries.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.android.ptvdb.tvseries.data.PosterResponse
import com.android.ptvdb.tvseries.data.TvShowResponse
import com.android.ptvdb.tvseries.viewmodel.TvShowViewModel
import com.android.ptvdb.tvseries.viewmodel.TvShowViewModelFactory

@Composable
fun TvShowScreen() {

    val tvShowViewModel: TvShowViewModel = viewModel(factory = TvShowViewModelFactory())

    tvShows(tvResponse = tvShowViewModel.tvResponse, tvShowViewModel)
}

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
        if (tvResponse.results.isNotEmpty()) {
            tvResponse.results.get(0).posterPath;

            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500/" + tvResponse.results[0].posterPath,
                contentDescription = "Translated description of what the image contains"
            )

         //   tvShowsPoster(tvPosterResponse = tvShowViewModel.posterResponse, tvShowViewModel)
        }
    }

}

@Composable
fun tvShowsPoster(tvPosterResponse: PosterResponse, tvShowViewModel: TvShowViewModel) {

    if (tvShowViewModel.isLoading) {
        //todo
    }else if(tvPosterResponse.posters.isNotEmpty()){
        tvPosterResponse.posters[0].filePath
    }

}

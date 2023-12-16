package com.android.ptvdb.screens.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.ptvdb.data.model.TvShows

@Composable
fun TvShowListContent(
    homeItemUiState: HomeItemUiState,
    tvShowLazyList: LazyListState,
    navigateToDetailScreen: (Int) -> Unit
) {
    Scaffold(modifier = Modifier.padding(20.dp),
        content = {it.calculateTopPadding()
            Box(modifier = Modifier
                .background(Color.White)
                .padding(top = 50.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),

                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(1.dp),
                    ) {
                        item {
                            TvShowList(
                                tvShowList = homeItemUiState.showList,
                                tvShowListState = tvShowLazyList,
                                navigateToDetailScreen = navigateToDetailScreen
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
private fun TvShowList(
    tvShowList: List<TvShows>,
    tvShowListState: LazyListState,
    navigateToDetailScreen: (Int) -> Unit
) {

    LazyRow(
        state = tvShowListState,
        contentPadding = PaddingValues(vertical = 50.dp)
    ) {
        items(items = tvShowList, key = { it.showName }) { show ->
            TvShowEach(tvShow = show, onClickShow = navigateToDetailScreen)
        }
    }
}

@Composable
private fun TvShowEach(tvShow: TvShows, onClickShow: (Int) -> Unit)
{
    Card(modifier = Modifier
        .width(150.dp)
        .clip(shape = MaterialTheme.shapes.large)
        .clickable(onClick = { onClickShow(tvShow.showId) }))
         {
            Column(verticalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.padding(vertical = 12.dp))

                //load image todo
                AsyncImage(model = tvShow.showPosterUrl, contentDescription = tvShow.showName + "image")

                Spacer(modifier = Modifier.padding(vertical = 12.dp))

                Text(text = tvShow.showName)

                //design to do
            }
        }



}


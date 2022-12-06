package com.vangelnum.hilt

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FavouriteScreen(viewModel: MyViewModel, pagerState: PagerState) {
    if (pagerState.currentPage == 1) {
        viewModel.getPhotosFromDataBase()
        val photosDB = viewModel.readAllData.observeAsState(listOf()).value
        viewModel.getPhotosFromDataBase()
        LazyColumn {
            items(photosDB) {
                AsyncImage(
                    model = it.url,
                    contentDescription = "null",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
            }
        }
    }
}

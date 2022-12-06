package com.vangelnum.hilt

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun MainScreen(viewModel: MyViewModel) {
    val photos by viewModel.items.collectAsState()
    viewModel.getPhotos()
    LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {
        items(photos) {
            Image(
                painter = rememberAsyncImagePainter(it.urls.full),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .clickable {
                        viewModel.addPhotoDatabase(RoomEntity(0, it.urls.full))
                    },
                contentScale = ContentScale.Crop
            )
        }
    }
}



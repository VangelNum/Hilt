package com.vangelnum.hilt

import com.vangelnum.hilt.data.UnsplashItem
import retrofit2.Response

interface MyRepository {
    suspend fun getPhotos(): Response<List<UnsplashItem>>
}
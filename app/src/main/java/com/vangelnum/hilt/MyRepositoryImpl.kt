package com.vangelnum.hilt

import com.vangelnum.hilt.data.UnsplashItem
import retrofit2.Response

class MyRepositoryImpl(
    private val api: MyApi,
) : MyRepository {
    override suspend fun getPhotos(): Response<List<UnsplashItem>> {
        return api.getPhotos()
    }
}
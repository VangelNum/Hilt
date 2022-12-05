package com.vangelnum.hilt

import android.util.Log
import com.vangelnum.hilt.data.UnsplashItem
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi
): MyRepository {
    override suspend fun getPhotos(): Response<List<UnsplashItem>> {
        return api.getPhotos()
    }
}
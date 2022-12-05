package com.vangelnum.hilt

import com.vangelnum.hilt.Constant.API_KEY
import com.vangelnum.hilt.data.UnsplashItem
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET ("/photos/?client_id=$API_KEY")
    suspend fun getPhotos() : Response<List<UnsplashItem>>
}
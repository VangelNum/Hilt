package com.vangelnum.hilt

import com.vangelnum.hilt.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMyRepository(
        api: MyApi
    ) : MyRepository {
        return MyRepositoryImpl(api)
    }
}
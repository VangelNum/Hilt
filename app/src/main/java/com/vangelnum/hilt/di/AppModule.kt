package com.vangelnum.hilt.di

import com.vangelnum.hilt.data.remote.MyApi
import com.vangelnum.hilt.data.repository.MyRepositoryImpl
import com.vangelnum.hilt.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi
    ) : MyRepository {
        return MyRepositoryImpl(api)
    }
}
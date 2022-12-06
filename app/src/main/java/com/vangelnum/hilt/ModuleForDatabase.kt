package com.vangelnum.hilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleForDatabase {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(
            context,
            RoomDatabase::class.java,
            "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideChannelDao(appDatabase: RoomDatabase): RoomDao {
        return appDatabase.getMyDao()
    }
}
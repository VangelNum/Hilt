package com.vangelnum.hilt

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomEntity::class], version = 3)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun getMyDao(): RoomDao
}
package com.vangelnum.hilt

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface RoomDao {
    @Query("SELECT * FROM photos_table")
    fun getAllPhotos(): LiveData<List<RoomEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun addPhoto(photo: RoomEntity)

    @Query("DELETE FROM photos_table WHERE url = :url")
    suspend fun deletePhotoUrl(url: String)

    @Delete
    suspend fun deletePhoto(photo: RoomEntity)
}
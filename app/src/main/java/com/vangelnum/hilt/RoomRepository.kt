package com.vangelnum.hilt

import androidx.lifecycle.LiveData
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val myDao: RoomDao,
) {
    fun getPhotos(): LiveData<List<RoomEntity>> {
        return myDao.getAllPhotos()
    }

    suspend fun addPhoto(photo: RoomEntity) {
        myDao.addPhoto(photo)
    }

    suspend fun deletePhoto(photo: RoomEntity) {
        myDao.deletePhoto(photo)
    }

    suspend fun deletePhotoUrl(url: String) {
        myDao.deletePhotoUrl(url)
    }
}
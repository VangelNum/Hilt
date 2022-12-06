package com.vangelnum.hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangelnum.hilt.data.UnsplashItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository,
    private val repositoryRoom: RoomRepository,
) : ViewModel() {

    private val _items = MutableStateFlow(emptyList<UnsplashItem>())
    var items: StateFlow<List<UnsplashItem>> = _items

    lateinit var readAllData: LiveData<List<RoomEntity>>

    fun getPhotosFromDataBase() {
        viewModelScope.launch {
            readAllData = repositoryRoom.getPhotos()
        }
    }

    fun addPhotoDatabase(photo: RoomEntity) {
        viewModelScope.launch {
            repositoryRoom.addPhoto(photo)
        }
    }

    fun deletePhotoDatabase(photo: RoomEntity) {
        viewModelScope.launch {
            repositoryRoom.deletePhoto(photo)
        }
    }

    fun deletePhotoDatabaseUrl(url: String) {
        viewModelScope.launch {
            repositoryRoom.deletePhotoUrl(url)
        }
    }


    fun getPhotos() {
        viewModelScope.launch {
            val response = repository.getPhotos()
            if (response.isSuccessful) {
                _items.value = response.body()!!
            }
        }
    }

}

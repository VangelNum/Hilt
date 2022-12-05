package com.vangelnum.hilt

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository,
) : ViewModel() {
    init {
        viewModelScope.launch {
            Log.d("TAG",repository.getPhotos().body().toString())
        }
    }



}
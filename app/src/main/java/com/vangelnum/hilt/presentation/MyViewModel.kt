package com.vangelnum.hilt.presentation

import androidx.lifecycle.ViewModel
import com.vangelnum.hilt.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {

}
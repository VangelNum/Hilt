package com.vangelnum.hilt.data.repository

import com.vangelnum.hilt.data.remote.MyApi
import com.vangelnum.hilt.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi
): MyRepository {
    override suspend fun doNetworkCall() {

    }
}
package com.vangelnum.hilt.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}
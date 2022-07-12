package com.devlee.daggerhiltexample.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}
package com.bikincerdas.core.data.source.remote.network

import com.bikincerdas.core.data.source.remote.response.ListRestaurantResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListRestaurantResponse
}

package com.bikincerdas.core.domain.repository

import com.bikincerdas.core.data.source.Resource
import com.bikincerdas.core.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface IRestaurantRepository {

    fun getAllRestaurant(): Flow<Resource<List<Restaurant>>>

    fun getFavoriteRestaurant(): Flow<List<Restaurant>>

    fun setFavoriteRestaurant(restaurant: Restaurant, state: Boolean)

}
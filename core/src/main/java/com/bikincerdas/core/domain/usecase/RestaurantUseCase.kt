package com.bikincerdas.core.domain.usecase

import com.bikincerdas.core.data.source.Resource
import com.bikincerdas.core.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantUseCase {
    fun getAllRestaurant(): Flow<Resource<List<Restaurant>>>
    fun getFavoriteRestaurant(): Flow<List<Restaurant>>
    fun setFavoriteRestaurant(Restaurant: Restaurant, state: Boolean)
}
package com.bikincerdas.restaurantcatalogue.detail

import androidx.lifecycle.ViewModel
import com.bikincerdas.core.domain.model.Restaurant
import com.bikincerdas.core.domain.usecase.RestaurantUseCase

class DetailRestaurantViewModel(private val restaurantUseCase: RestaurantUseCase) : ViewModel() {
    fun setFavoriteRestaurant(restaurant: Restaurant, newStatus:Boolean) =
        restaurantUseCase.setFavoriteRestaurant(restaurant, newStatus)
}


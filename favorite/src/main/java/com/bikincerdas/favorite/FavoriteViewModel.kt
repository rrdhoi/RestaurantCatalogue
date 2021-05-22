package com.bikincerdas.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bikincerdas.core.domain.usecase.RestaurantUseCase

class FavoriteViewModel(restaurantUseCase: RestaurantUseCase) : ViewModel() {
    val favoriteRestaurant = restaurantUseCase.getFavoriteRestaurant().asLiveData()
}


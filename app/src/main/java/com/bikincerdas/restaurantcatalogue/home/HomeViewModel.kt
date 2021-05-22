package com.bikincerdas.restaurantcatalogue.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bikincerdas.core.domain.usecase.RestaurantUseCase

class HomeViewModel(RestaurantUseCase: RestaurantUseCase) : ViewModel() {
    val restaurant = RestaurantUseCase.getAllRestaurant().asLiveData()
}


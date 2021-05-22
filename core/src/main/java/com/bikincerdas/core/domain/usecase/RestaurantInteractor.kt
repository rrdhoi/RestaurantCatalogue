package com.bikincerdas.core.domain.usecase

import com.bikincerdas.core.domain.model.Restaurant
import com.bikincerdas.core.domain.repository.IRestaurantRepository

class RestaurantInteractor(private val RestaurantRepository: IRestaurantRepository): RestaurantUseCase {

    override fun getAllRestaurant() = RestaurantRepository.getAllRestaurant()

    override fun getFavoriteRestaurant() = RestaurantRepository.getFavoriteRestaurant()

    override fun setFavoriteRestaurant(Restaurant: Restaurant, state: Boolean) = RestaurantRepository.setFavoriteRestaurant(Restaurant, state)
}
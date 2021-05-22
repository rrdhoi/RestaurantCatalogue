package com.bikincerdas.core.data.source.local

import com.bikincerdas.core.data.source.local.entity.RestaurantEntity
import com.bikincerdas.core.data.source.local.room.RestaurantDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val restaurantDao: RestaurantDao) {

    fun getAllRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.getAllRestaurant()

    fun getFavoriteRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.getFavoriteRestaurant()

    suspend fun insertRestaurant(restaurantList: List<RestaurantEntity>) = restaurantDao.insertRestaurant(restaurantList)

    fun setFavoriteRestaurant(restaurant: RestaurantEntity, newState: Boolean) {
        restaurant.isFavorite = newState
        restaurantDao.updateFavoriteRestaurant(restaurant)
    }
}
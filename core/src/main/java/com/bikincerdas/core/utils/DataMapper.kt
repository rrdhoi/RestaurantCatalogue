package com.bikincerdas.core.utils

import com.bikincerdas.core.data.source.local.entity.RestaurantEntity
import com.bikincerdas.core.data.source.remote.response.RestaurantResponse
import com.bikincerdas.core.domain.model.Restaurant

object DataMapper {
    fun mapResponsesToEntities(input: List<RestaurantResponse>): List<RestaurantEntity> {
        val tourismList = ArrayList<RestaurantEntity>()
        input.map {
            val tourism = RestaurantEntity(
                restaurantId = it.id,
                name = it.name,
                description = it.description,
                pictureId = "https://restaurant-api.dicoding.dev/images/medium/${it.pictureId}",
                city = it.city,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<RestaurantEntity>): List<Restaurant> =
        input.map {
            Restaurant(
                restaurantId = it.restaurantId,
                name = it.name,
                description = it.description,
                pictureId = it.pictureId,
                city = it.city,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Restaurant) = RestaurantEntity(
        restaurantId = input.restaurantId,
        name = input.name,
        description = input.description,
        pictureId = input.pictureId,
        city = input.city,
        isFavorite = input.isFavorite
    )
}
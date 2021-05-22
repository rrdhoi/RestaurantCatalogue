package com.bikincerdas.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
    val restaurantId: String,
    val name: String,
    val description: String,
    val pictureId: String,
    val city: String,
    val isFavorite: Boolean
) : Parcelable
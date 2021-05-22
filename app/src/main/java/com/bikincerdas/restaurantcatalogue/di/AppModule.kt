package com.bikincerdas.restaurantcatalogue.di

import com.bikincerdas.core.domain.usecase.RestaurantInteractor
import com.bikincerdas.core.domain.usecase.RestaurantUseCase
import com.bikincerdas.restaurantcatalogue.detail.DetailRestaurantViewModel
import com.bikincerdas.restaurantcatalogue.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<RestaurantUseCase> { RestaurantInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailRestaurantViewModel(get()) }
}
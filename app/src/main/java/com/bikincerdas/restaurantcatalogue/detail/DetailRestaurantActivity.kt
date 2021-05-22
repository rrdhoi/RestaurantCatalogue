package com.bikincerdas.restaurantcatalogue.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bikincerdas.core.domain.model.Restaurant
import com.bikincerdas.restaurantcatalogue.R
import com.bikincerdas.restaurantcatalogue.databinding.ActivityDetailRestaurantBinding
import com.bumptech.glide.Glide
import org.koin.android.viewmodel.ext.android.viewModel

class DetailRestaurantActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailRestaurantViewModel: DetailRestaurantViewModel by viewModel()
    private lateinit var binding: ActivityDetailRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailRestaurant = intent.getParcelableExtra<Restaurant>(EXTRA_DATA)
        showDetailRestaurant(detailRestaurant)
    }

    private fun showDetailRestaurant(detailRestaurant: Restaurant?) {
        detailRestaurant?.let {
            supportActionBar?.title = detailRestaurant.name
            binding.content.tvDetailDescription.text = detailRestaurant.description
            Glide.with(this@DetailRestaurantActivity)
                .load(detailRestaurant.pictureId)
                .into(binding.ivDetailImage)

            var statusFavorite = detailRestaurant.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailRestaurantViewModel.setFavoriteRestaurant(detailRestaurant, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}
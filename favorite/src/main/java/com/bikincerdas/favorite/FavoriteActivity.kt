package com.bikincerdas.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bikincerdas.core.ui.RestaurantAdapter
import com.bikincerdas.favorite.databinding.ActivityFavoriteBinding
import com.bikincerdas.favorite.di.favoriteModule
import com.bikincerdas.restaurantcatalogue.detail.DetailRestaurantActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)
        supportActionBar?.title = "Favorite"

        val restaurantAdapter = RestaurantAdapter()
        restaurantAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailRestaurantActivity::class.java)
            intent.putExtra(DetailRestaurantActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteRestaurant.observe(this) { dataRestaurant ->
            restaurantAdapter.setData(dataRestaurant)
        }

        with(binding.rvRestaurant) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = restaurantAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(favoriteModule)
    }
}